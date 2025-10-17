package com.dchans.api.app.dto.main;

import com.dchans.api.app.dto.banner.AppBannerDto;
import com.dchans.api.app.dto.policy.AppPolicyDto;
import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.app.dto.review.AppReviewDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AppMainDto {
    private List<AppStoreDto> popularStoreDto;
    private List<AppStoreDto> allStoreDto;
    private List<AppStoreDto> nearStoreDto;
    private List<AppProductDto> productDto;
    private List<AppReviewDto> reviewDto;
    private AppPolicyDto termDto;
    private AppPolicyDto privacyDto;
    private List<AppBannerDto> mainBannerDto;
    private List<AppBannerDto> mainBanner2Dto;
}
