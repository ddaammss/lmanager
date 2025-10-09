package com.dchans.api.app.service.main;

import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.app.dto.review.AppReviewDto;
import com.dchans.api.app.dto.store.AppStoreDto;

import java.util.List;

public interface AppMainService {
    List<AppStoreDto> selectAllStoreList();
    List<AppStoreDto> selectNearStoreList();
    List<AppProductDto> selectProductList();
    List<AppReviewDto> selectReviewList();
}
