package com.dchans.api.app.controller.store;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import com.dchans.api.app.service.store.AppStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api")
public class AppStoreController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AppStoreService appStoreService;

    public AppStoreController(AppStoreService appStoreService) {
        this.appStoreService = appStoreService;
    }

    @PostMapping("/store")
    public ResponseEntity<ApiResponseDto<AppStoreDto>> selectAppStoreData(@RequestBody AppStoreDto appStoreDto) {
        AppStoreDto storeDto = appStoreService.selectAppStoreListData(appStoreDto);
        return ResponseEntity.ok(ApiResponseDto.success(storeDto));
    }

    @PostMapping("/store_detail")
    public ResponseEntity<ApiResponseDto<AppStoreDto>> selectAppStoreDetailData(@RequestBody AppStoreDto appStoreDto) {
        AppStoreDto storeDto = appStoreService.selectStoreDetail(appStoreDto);
        return ResponseEntity.ok(ApiResponseDto.success(storeDto));
    }
}
