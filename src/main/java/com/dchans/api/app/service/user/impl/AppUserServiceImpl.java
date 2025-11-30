package com.dchans.api.app.service.user.impl;

import com.dchans.api.app.dao.user.AppUserDao;
import com.dchans.api.app.dto.user.AppUserDto;
import com.dchans.api.app.service.user.AppUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Resource(name = "AppUserDao")
    private AppUserDao appUserDao;
    private static final String NAMESPACE = "com.app.user.";

    @Override
    public AppUserDto.UserResponseDto selectAppUserData(AppUserDto.UserRequestDto requestDto) {
        return appUserDao.selectAppUserData(NAMESPACE + "selectAppUserData", requestDto);
    }
}
