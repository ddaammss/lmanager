package com.dchans.api.admin.service.login.impl;

import com.dchans.api.admin.dao.login.LoginDao;
import com.dchans.api.admin.dto.jwt.TokenResponseDto;
import com.dchans.api.admin.dto.login.LoginDto;
import com.dchans.api.admin.service.login.LoginService;
import com.dchans.api.common.JwtTokenService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource(name = "LoginDao")
    private LoginDao loginDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String NAMESPACE = "com.admin.";
    private final JwtTokenService tokenService;

    public LoginServiceImpl(JwtTokenService tokenService) {
        this.tokenService = tokenService;
    }

    public TokenResponseDto selectManagerOne(LoginDto.LoginRequestDto requestDto) {
        LoginDto.LoginResponseDto responseDto = loginDao.selectManagerOne(NAMESPACE + "selectManagerOne", requestDto);

        if (responseDto == null) {
            logger.error("존재하지 않는 사용자: userid={}", requestDto.getId());
            throw new RuntimeException("사용자를 찾을 수 없습니다");
        }

        String accessToken = tokenService.generateAccessToken(responseDto.getId(), responseDto.getRole());
        String refreshToken = tokenService.generateRefreshToken(responseDto.getId());
        TokenResponseDto tokenResponseDto = new TokenResponseDto(accessToken, refreshToken);
        tokenResponseDto.setAccessToken(accessToken);
        tokenResponseDto.setRefreshToken(refreshToken);
        tokenResponseDto.setUsername(responseDto.getId());
        return tokenResponseDto;
    }
}
