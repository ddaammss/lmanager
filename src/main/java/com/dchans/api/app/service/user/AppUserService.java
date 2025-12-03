package com.dchans.api.app.service.user;

import com.dchans.api.app.dto.point.AppPointDto;
import com.dchans.api.app.dto.user.AppUserDto;

public interface AppUserService {

    AppUserDto.UserResponseDto selectAppUserData(AppUserDto.UserRequestDto requestDto);

    int updateUser(AppUserDto.UserRequestDto requestDto);

    AppPointDto selectAppUserPointData(AppPointDto.PointRequestDto requestDto);
}
