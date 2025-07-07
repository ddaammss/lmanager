package com.dchans.api.admin.service.login;

import com.dchans.api.admin.dto.login.LoginDto;

public interface LoginService {

    LoginDto.LoginResponseDto selectManagerOne(LoginDto loginDto);
}
