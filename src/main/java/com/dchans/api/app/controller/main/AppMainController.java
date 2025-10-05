package com.dchans.api.app.controller.main;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.main.AppMainDto;
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

    private final AppStoreService appStoreService;
    private final AppReviewService appReviewService;

    public AppMainController(AppStoreService appStoreService, AppReviewService appReviewService) {
        this.appStoreService = appStoreService;
        this.appReviewService = appReviewService;
    }
    //private final ProductService productService;


    @PostMapping
    public ResponseEntity<ApiResponseDto<AppMainDto>> getMainData() {
        AppMainDto mainDto = new AppMainDto();
//        mainDto.setStoreDto(store);
//        mainDto.setProductDto();
//        mainDto.setReviewDto();
//        MainDto mainData = MainDto.builder()
//                .allStores(storeService.getAllStores())
//                .nearbyStores(storeService.getNearbyStores())
//                .popularStores(storeService.getPopularStores())
//                .recommendProducts(productService.getRecommendProducts())
//                .bestReviews(reviewService.getBestReviews())
//                .build();

        return ResponseEntity.ok(ApiResponseDto.success(mainDto));
    }

}
