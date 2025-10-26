package com.dchans.api.app.service.event;

import com.dchans.api.app.dto.event.AppEventDto;
import com.dchans.api.app.dto.store.AppStoreDto;

import java.util.List;

public interface AppEventService {

    AppEventDto selectAppEventListData(AppEventDto appEventDto);

    AppEventDto selectAppEventDetailData(AppEventDto appEventDto);
}
