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
    public AppNaverDto selectNaverUserData(AppNaverDto appNaverDto) {
        return appLoginDao.selectNaverUserData(NAMESPACE + "selectNaverUserData", appNaverDto);
    }

    @Override
    public void insertNaverUserData(AppNaverDto appNaverDto) {
        appLoginDao.insertNaverUserData(NAMESPACE + "insertNaverUserData", appNaverDto);

    }
}
