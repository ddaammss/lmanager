package com.dchans.api.app.service.user;

import com.dchans.api.app.dto.user.AppUserDto;

public interface AppUserService {

    AppUserDto.UserResponseDto selectAppUserData(AppUserDto.UserRequestDto requestDto);

}
