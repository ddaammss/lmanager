package com.dchans.api.app.service.main.impl;

import com.dchans.api.app.dao.main.AppMainDao;
import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.app.dto.review.AppReviewDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import com.dchans.api.app.service.main.AppMainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppMainServiceImpl implements AppMainService {
    @Resource(name = "AppMainDao")
    private AppMainDao appMainDao;
    private static final String NAMESPACE = "com.app.main.";

    @Override
    public List<AppStoreDto> selectAllStoreList() {
        return appMainDao.selectAllStoreList(NAMESPACE + "selectAllStoreList");
    }

    @Override
    public List<AppStoreDto> selectNearStoreList() {
        return appMainDao.selectNearStoreList(NAMESPACE + "selectNearStoreList");
    }

    @Override
    public List<AppProductDto> selectProductList() {
        return appMainDao.selectProductList(NAMESPACE + "selectProductList");
    }

    @Override
    public List<AppReviewDto> selectReviewList() {
        return appMainDao.selectReviewList(NAMESPACE + "selectReviewList");
    }
}
