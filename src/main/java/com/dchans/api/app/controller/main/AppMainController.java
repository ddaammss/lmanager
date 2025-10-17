package com.dchans.api.app.controller.main;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.main.AppMainDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import com.dchans.api.app.service.main.AppMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api")
public class AppMainController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AppMainService appMainService;

    public AppMainController(AppMainService appMainService) {
        this.appMainService = appMainService;
    }

    @PostMapping("/main")
    public ResponseEntity<ApiResponseDto<AppMainDto>> getAppMainData(@RequestBody AppStoreDto appStoreDto) {
        AppMainDto mainDto = AppMainDto.builder()
                .popularStoreDto(appMainService.selectPopularityStoreList())
                .allStoreDto(appMainService.selectAllStoreList())
                .nearStoreDto(appMainService.selectNearStoreList(appStoreDto))
                .productDto(appMainService.selectProductList())
                .reviewDto(appMainService.selectReviewList())
                .termDto(appMainService.selectTermDetail())
                .privacyDto(appMainService.selectPrivacyDetail())
                .mainBannerDto(appMainService.selectMainBannerList())
                .mainBanner2Dto(appMainService.selectMainBanner2List())
                .build();
        return ResponseEntity.ok(ApiResponseDto.success(mainDto));
    }

}
