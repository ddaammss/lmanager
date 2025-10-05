package com.dchans.api.app.dao.store;

import com.dchans.api.admin.dto.store.StoreDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppStoreDao")
public class AppStoreDao extends AbstractMapper {
    public AppStoreDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }
}
