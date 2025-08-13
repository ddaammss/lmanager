package com.dchans.api.admin.dao.settings.policy;

import com.dchans.api.admin.dto.settings.policy.PolicyDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("RefundDao")
public class RefundDao extends AbstractMapper {
    public RefundDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public PolicyDto selectRefundDetail(String s, PolicyDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer upsertRefund(String s, PolicyDto requestDto) {
        return insert(s, requestDto);
    }
}
