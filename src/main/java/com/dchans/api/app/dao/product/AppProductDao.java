package com.dchans.api.app.dao.product;

import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppProductDao")
public class AppProductDao extends AbstractMapper {
    public AppProductDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<AppProductDto> selectProductList(String s) {
        return selectList(s);
    }
}
