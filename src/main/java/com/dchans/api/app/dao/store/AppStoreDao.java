package com.dchans.api.app.dao.store;

import com.dchans.api.app.dto.image.AppImageDto;
import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.app.dto.review.AppReviewDto;
import com.dchans.api.app.dto.store.AppStoreDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppStoreDao")
public class AppStoreDao extends AbstractMapper {
    public AppStoreDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<AppStoreDto> selectAppStoreListData(String s, AppStoreDto appStoreDto) {
        return selectList(s, appStoreDto);
    }

    public AppStoreDto selectStoreDetail(String s, AppStoreDto appStoreDto) {
        return selectOne(s, appStoreDto);
    }

    public List<AppProductDto> selectProductList(String s, AppStoreDto appStoreDto) {
        return selectList(s, appStoreDto);
    }

    public List<AppReviewDto> selectReviewList(String s, AppStoreDto appStoreDto) {
        return selectList(s, appStoreDto);
    }

    public List<AppImageDto> selectImageList(String s, AppStoreDto appStoreDto) {
        return selectList(s, appStoreDto);
    }


}
