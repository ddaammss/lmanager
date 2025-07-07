package com.dchans.api.admin.service.login.impl;

import com.dchans.api.admin.dao.login.LoginDao;
import com.dchans.api.admin.dto.login.LoginDto;
import com.dchans.api.admin.entity.login.ManagerEntity;
import com.dchans.api.admin.service.login.LoginService;
import com.dchans.api.common.JwtTokenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource(name = "LoginDao")
    private LoginDao loginDao;

    private final String NAMESPACE = "com.admin.";
    private final JwtTokenService tokenService;

    public LoginServiceImpl(JwtTokenService tokenService) {
        this.tokenService = tokenService;
    }

    public LoginDto.LoginResponseDto selectManagerOne(LoginDto loginDto) {
        ManagerEntity managerEntity = loginDao.selectManagerOne(NAMESPACE + "selectManagerOne", loginDto);
        String accessToken = tokenService.generateAccessToken(managerEntity.getName(), managerEntity.getRole());
        String refreshToken = tokenService.generateRefreshToken(managerEntity.getName());
        LoginDto.LoginResponseDto loginResponseDto = new LoginDto.LoginResponseDto();
        loginResponseDto.setAccessToken(accessToken);
        loginResponseDto.setRefreshToken(refreshToken);
        loginResponseDto.setUsername(managerEntity.getName());
        return loginResponseDto;
    }
}
