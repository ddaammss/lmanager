package com.dchans.api.app.service.event;

import com.dchans.api.app.dao.event.AppEventDao;
import com.dchans.api.app.dao.store.AppStoreDao;
import com.dchans.api.app.dto.event.AppEventDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppEventServiceImpl implements AppEventService {
    @Resource(name = "AppEventDao")
    private AppEventDao appEventDao;
    private static final String NAMESPACE = "com.app.event.";

    @Override
    public AppEventDto selectAppEventListData(AppEventDto appEventDto) {
        List<AppEventDto> response = appEventDao.selectAppEventListData(NAMESPACE + "selectAppEventListData");

        LocalDate today = LocalDate.now();
        for (AppEventDto event : response) {
            LocalDate endDate = LocalDate.parse(event.getEndDate());
            event.setStatus(endDate.isBefore(today) ? "closed" : "active");
        }
        return AppEventDto.builder().eventListDto(response).build();
    }

    @Override
    public AppEventDto selectAppEventDetailData(AppEventDto appEventDto) {
        AppEventDto response =  appEventDao.selectAppEventDetailData(NAMESPACE + "selectAppEventDetailData", appEventDto);
        response.setImageListDto(appEventDao.selecAppEventImage(NAMESPACE + "selecAppEventImage", appEventDto));
        return response;
    }
}
