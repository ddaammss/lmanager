package com.dchans.api.app.service.store;

import com.dchans.api.app.dto.store.AppStoreDto;

public interface AppStoreService {

    AppStoreDto selectAppStoreListData(AppStoreDto appStoreDto);

    AppStoreDto selectStoreDetail(AppStoreDto appStoreDto);
}
