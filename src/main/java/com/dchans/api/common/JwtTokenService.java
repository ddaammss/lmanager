package com.dchans.api.common;

import com.dchans.api.admin.dto.jwt.TokenResponseDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenService {
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.access-token.validity}")
    private Long accessTokenValidity;

    @Value("${jwt.refresh-token.validity}")
    private Long refreshTokenValidity;

    private final SecretKey secretKey;

    public JwtTokenService(@Value("${jwt.secret}") String secret) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Access Token 생성
     */
    public String generateAccessToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("role", role);

        return createToken(claims, username, accessTokenValidity);
    }

    /**
     * Refresh Token 생성
     */
    public String generateRefreshToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("type", "refresh");

        return createToken(claims, username, refreshTokenValidity);
    }

    /**
     * 토큰 생성 공통 메서드
     */
    private String createToken(Map<String, Object> claims, String subject, long validity) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + validity);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Access Token과 Refresh Token을 함께 발급
     */
    public TokenResponseDto issueTokens(String username, String role) {
        String accessToken = generateAccessToken(username, role);
        String refreshToken = generateRefreshToken(username);

        return new TokenResponseDto(accessToken, refreshToken);
    }

    /**
     * 토큰에서 사용자명 추출
     */
    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    /**
     * 토큰에서 사용자 역할(Role) 추출
     */
    public String getRoleFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.get("role", String.class);
    }

    /**
     * 토큰에서 Claims 추출
     */
    private Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 토큰 유효성 검증
     */
    public boolean validateToken(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Refresh Token으로 새로운 Access Token 발급
     */
    public String refreshAccessToken(String refreshToken, String role) {
        if (validateToken(refreshToken)) {
            String username = getUsernameFromToken(refreshToken);
            return generateAccessToken(username, role);
        }
        throw new RuntimeException("Invalid refresh token");
    }


}
