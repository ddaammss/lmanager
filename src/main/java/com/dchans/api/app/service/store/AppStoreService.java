package com.dchans.api.app.service.store;

import com.dchans.api.app.dto.store.AppStoreDto;

import java.util.List;

public interface AppStoreService {

    AppStoreDto selectStoreDetail(AppStoreDto appStoreDto);
}
