package com.dchans.api.app.controller.event;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.event.AppEventDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import com.dchans.api.app.service.event.AppEventService;
import com.dchans.api.app.service.store.AppStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/api/event")
public class AppEventController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AppEventService appEventService;

    public AppEventController(AppEventService appEventService) {
        this.appEventService = appEventService;
    }

    @PostMapping("/list")
    public ResponseEntity<ApiResponseDto<AppEventDto>> selectAppEventListData(@RequestBody AppEventDto appEventDto) {
        AppEventDto eventDto = appEventService.selectAppEventListData(appEventDto);
        return ResponseEntity.ok(ApiResponseDto.success(eventDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<AppEventDto>> selectAppEventDetailData(@RequestBody AppEventDto appEventDto) {
        AppEventDto eventDto = appEventService.selectAppEventDetailData(appEventDto);
        return ResponseEntity.ok(ApiResponseDto.success(eventDto));
    }


}
