package com.dchans.api.app.service.login;

import com.dchans.api.app.dto.login.AppNaverDto;
import com.dchans.api.app.dto.store.AppStoreDto;

public interface AppLoginService {

    AppNaverDto selectNaverUserData(AppNaverDto appNaverDto);

    void insertNaverUserData(AppNaverDto appNaverDto);
}
