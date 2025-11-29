package com.dchans.api.app.service.login;

import com.dchans.api.app.dto.login.AppNaverDto;
import com.dchans.api.app.dto.store.AppStoreDto;

public interface AppLoginService {

    AppNaverDto.NaverLoginResponseDto selectNaverUserData(AppNaverDto.NaverLoginRequestDto requestDto);

    void insertNaverUserData(AppNaverDto.NaverLoginRequestDto requestDto);

    AppNaverDto.NaverLoginResponseDto selectKakaoUserData(AppNaverDto.NaverLoginRequestDto requestDto);

    void insertKakaoUserData(AppNaverDto.NaverLoginRequestDto requestDto);
}
