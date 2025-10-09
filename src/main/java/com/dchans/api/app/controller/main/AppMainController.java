package com.dchans.api.app.controller.main;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.main.AppMainDto;
import com.dchans.api.app.service.main.AppMainService;
import com.dchans.api.app.service.product.AppProductService;
import com.dchans.api.app.service.review.AppReviewService;
import com.dchans.api.app.service.store.AppStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api/main")
public class AppMainController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    private final AppStoreService appStoreService;
//    private final AppReviewService appReviewService;
//    private final AppProductService appProductService;
    private final AppMainService appMainService;

    public AppMainController(AppMainService appMainService) {
        this.appMainService = appMainService;
    }

//    public AppMainController(AppStoreService appStoreService, AppReviewService appReviewService, AppProductService appProductService) {
//        this.appStoreService = appStoreService;
//        this.appReviewService = appReviewService;
//        this.appProductService = appProductService;
//    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<AppMainDto>> getAppMainData() {
        AppMainDto mainDto = AppMainDto.builder()
                .allStoreDto(appMainService.selectAllStoreList())
                .nearStoreDto(appMainService.selectNearStoreList())
                .productDto(appMainService.selectProductList())
                .reviewDto(appMainService.selectReviewList())
                .build();
        return ResponseEntity.ok(ApiResponseDto.success(mainDto));
    }

}
