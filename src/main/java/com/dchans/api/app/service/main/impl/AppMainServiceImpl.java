package com.dchans.api.app.service.main.impl;

import com.dchans.api.app.dao.main.AppMainDao;
import com.dchans.api.app.dto.banner.AppBannerDto;
import com.dchans.api.app.dto.policy.AppPolicyDto;
import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.app.dto.review.AppReviewDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import com.dchans.api.app.service.main.AppMainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
    public List<AppStoreDto> selectNearStoreList(AppStoreDto appStoreDto) {
        return calculateAndSort(appStoreDto.getLatitude(), appStoreDto.getLongitude(), appStoreDto.getDistance(), appMainDao.selectNearStoreList(NAMESPACE + "selectNearStoreList", appStoreDto));
    }

    @Override
    public List<AppProductDto> selectProductList() {
        return appMainDao.selectProductList(NAMESPACE + "selectProductList");
    }

    @Override
    public List<AppReviewDto> selectReviewList() {
        return appMainDao.selectReviewList(NAMESPACE + "selectReviewList");
    }

    @Override
    public AppPolicyDto selectTermDetail() {
        return appMainDao.selectTermDetail(NAMESPACE + "selectTermDetail");
    }

    @Override
    public AppPolicyDto selectPrivacyDetail() {
        return appMainDao.selectPrivacyDetail(NAMESPACE + "selectPrivacyDetail");
    }

    @Override
    public List<AppBannerDto> selectMainBannerList() {
        return appMainDao.selectMainBannerList(NAMESPACE + "selectMainBannerList");
    }

    @Override
    public List<AppBannerDto> selectMainBanner2List() {
        return appMainDao.selectMainBanner2List(NAMESPACE + "selectMainBanner2List");
    }

    private static List<AppStoreDto> calculateAndSort(double userLat, double userLon,
                                               double radius, List<AppStoreDto> allStores) {

        List<AppStoreDto> nearbyStores = new ArrayList<>();

        // 각 입점사와의 거리 계산
        for (AppStoreDto store : allStores) {
            double distance = calculateDistance(
                    userLat, userLon,
                    store.getLatitude(), store.getLongitude()
            );

            // 반경 내에 있는 입점사만 추가
            if (distance <= radius) {
                store.setDistance(Math.round(distance * 100.0) / 100.0); // 소수점 2자리
                nearbyStores.add(store);
            }
        }

        // 거리순으로 정렬 (가까운 순)
        nearbyStores.sort(Comparator.comparingDouble(AppStoreDto::getDistance));

        return nearbyStores;
    }

    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int EARTH_RADIUS = 6371; // 지구 반지름 (km)

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

}
