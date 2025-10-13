package com.dchans.api.app.dao.main;

import com.dchans.api.app.dto.banner.AppBannerDto;
import com.dchans.api.app.dto.policy.AppPolicyDto;
import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.app.dto.review.AppReviewDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppMainDao")
public class AppMainDao extends AbstractMapper {
    public AppMainDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }
    public List<AppStoreDto> selectAllStoreList(String s) {
        return selectList(s);
    }
    public List<AppStoreDto> selectNearStoreList(String s, AppStoreDto appStoreDto) {
        return selectList(s,appStoreDto);
    }
    public List<AppProductDto> selectProductList(String s) {
        return selectList(s);
    }
    public List<AppReviewDto> selectReviewList(String s) {
        return selectList(s);
    }
    public AppPolicyDto selectTermDetail(String s) {
        return selectOne(s);
    }
    public AppPolicyDto selectPrivacyDetail(String s) {
        return selectOne(s);
    }
    public List<AppBannerDto> selectMainBannerList(String s) {
        return selectList(s);
    }
    public List<AppBannerDto> selectMainBanner2List(String s) {
        return selectList(s);
    }
}
