package com.dchans.api.app.service.main;

import com.dchans.api.app.dto.banner.AppBannerDto;
import com.dchans.api.app.dto.policy.AppPolicyDto;
import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.app.dto.review.AppReviewDto;
import com.dchans.api.app.dto.store.AppStoreDto;

import java.util.List;

public interface AppMainService {
    List<AppStoreDto> selectAllStoreList();
    List<AppStoreDto> selectNearStoreList(AppStoreDto appStoreDto);
    List<AppProductDto> selectProductList();
    List<AppReviewDto> selectReviewList();
    AppPolicyDto selectTermDetail();
    AppPolicyDto selectPrivacyDetail();
    List<AppBannerDto> selectMainBannerList();
    List<AppBannerDto> selectMainBanner2List();
}
