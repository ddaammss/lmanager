package com.dchans.api.admin.service.login;

import com.dchans.api.admin.dto.jwt.TokenResponseDto;
import com.dchans.api.admin.dto.login.LoginDto;

public interface LoginService {

    TokenResponseDto selectManagerOne(LoginDto.LoginRequestDto requestDto);
}
