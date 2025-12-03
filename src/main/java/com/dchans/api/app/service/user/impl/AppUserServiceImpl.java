package com.dchans.api.app.service.user.impl;

import com.dchans.api.app.dao.user.AppUserDao;
import com.dchans.api.app.dto.point.AppPointDto;
import com.dchans.api.app.dto.reservation.AppReservationDto;
import com.dchans.api.app.dto.user.AppUserDto;
import com.dchans.api.app.service.user.AppUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Resource(name = "AppUserDao")
    private AppUserDao appUserDao;
    private static final String NAMESPACE = "com.app.user.";

    @Override
    public AppUserDto.UserResponseDto selectAppUserData(AppUserDto.UserRequestDto requestDto) {
        return appUserDao.selectAppUserData(NAMESPACE + "selectAppUserData", requestDto);
    }

    @Override
    public int updateUser(AppUserDto.UserRequestDto requestDto) {
        return appUserDao.updateUser(NAMESPACE + "updateUser", requestDto);
    }

    @Override
    public AppPointDto selectAppUserPointData(AppPointDto.PointRequestDto requestDto) {
        AppPointDto responseDto = new AppPointDto();
        responseDto.setPointResponseDtos(appUserDao.selectAppUserPointData(NAMESPACE + "selectAppUserPointData", requestDto));
        return responseDto;

    }
}
