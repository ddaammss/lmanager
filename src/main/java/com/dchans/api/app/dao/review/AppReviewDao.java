package com.dchans.api.app.dao.review;

import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("ReviewDao")
public class AppReviewDao extends AbstractMapper {
    public AppReviewDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }
}
