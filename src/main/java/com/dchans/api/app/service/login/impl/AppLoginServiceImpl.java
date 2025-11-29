package com.dchans.api.app.service.login.impl;

import com.dchans.api.app.dao.login.AppLoginDao;
import com.dchans.api.app.dto.login.AppNaverDto;
import com.dchans.api.app.service.login.AppLoginService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AppLoginServiceImpl implements AppLoginService {
    @Resource(name = "AppLoginDao")
    private AppLoginDao appLoginDao;
    private static final String NAMESPACE = "com.app.login.";


    @Override
    public AppNaverDto.NaverLoginResponseDto selectNaverUserData(AppNaverDto.NaverLoginRequestDto requestDto) {
        return appLoginDao.selectNaverUserData(NAMESPACE + "selectNaverUserData", requestDto);
    }

    @Override
    public void insertNaverUserData(AppNaverDto.NaverLoginRequestDto requestDto) {
        appLoginDao.insertNaverUserData(NAMESPACE + "insertNaverUserData", requestDto);

    }

    @Override
    public AppNaverDto.NaverLoginResponseDto selectKakaoUserData(AppNaverDto.NaverLoginRequestDto requestDto) {
        return appLoginDao.selectKakaoUserData(NAMESPACE + "selectKakaoUserData", requestDto);
    }

    @Override
    public void insertKakaoUserData(AppNaverDto.NaverLoginRequestDto requestDto) {
        appLoginDao.insertKakaoUserData(NAMESPACE + "insertKakaoUserData", requestDto);
    }
}
