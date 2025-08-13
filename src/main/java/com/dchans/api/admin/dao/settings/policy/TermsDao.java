package com.dchans.api.admin.dao.settings.policy;

import com.dchans.api.admin.dto.settings.policy.PolicyDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("TermsDao")
public class TermsDao extends AbstractMapper {
    public TermsDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public PolicyDto selectTermsDetail(String s, PolicyDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer upsertTerms(String s, PolicyDto requestDto) {
        return insert(s, requestDto);
    }
}
