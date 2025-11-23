package com.dchans.api.app.service.store.impl;

import com.dchans.api.app.dao.store.AppStoreDao;
import com.dchans.api.app.dto.store.AppStoreDto;
import com.dchans.api.app.service.store.AppStoreService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AppStoreServiceImpl implements AppStoreService {
    @Resource(name = "AppStoreDao")
    private AppStoreDao appStoreDao;
    private static final String NAMESPACE = "com.app.store.";


    @Override
    public AppStoreDto selectAppStoreListData(AppStoreDto appStoreDto) {
        AppStoreDto appStoreDtoResponse = new AppStoreDto();
        appStoreDtoResponse.setProductDto(appStoreDao.selectProductList(NAMESPACE + "selectProductList", appStoreDto));
        appStoreDtoResponse.setImageDto(appStoreDao.selectImageList(NAMESPACE + "selectImageList", appStoreDto));
        appStoreDtoResponse.setStoreListDto(appStoreDao.selectAppStoreListData(NAMESPACE + "selectAppStoreListData", appStoreDto));
        appStoreDtoResponse.setSubBannerDto(appStoreDao.selectSubBannerList(NAMESPACE + "selectSubBannerList", appStoreDto));
        return appStoreDtoResponse;
    }

    @Override
    public AppStoreDto selectStoreDetail(AppStoreDto appStoreDto) {
        AppStoreDto response = appStoreDao.selectStoreDetail(NAMESPACE + "selectStoreDetail", appStoreDto);
        if (response != null) {
            response.setProductDto(appStoreDao.selectProductList(NAMESPACE + "selectProductList", appStoreDto));
            response.setReviewDto(appStoreDao.selectReviewList(NAMESPACE + "selectReviewList", appStoreDto));
            response.setImageDto(appStoreDao.selectImageList(NAMESPACE + "selectImageList", appStoreDto));

            return response;
        }
        return appStoreDto;
    }
}
