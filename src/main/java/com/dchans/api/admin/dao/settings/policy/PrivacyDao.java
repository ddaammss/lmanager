package com.dchans.api.admin.dao.settings.policy;

import com.dchans.api.admin.dto.settings.policy.PolicyDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("PrivacyDao")
public class PrivacyDao extends AbstractMapper {
    public PrivacyDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public PolicyDto selectPrivacyDetail(String s, PolicyDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer upsertPrivacy(String s, PolicyDto requestDto) {
        return insert(s, requestDto);
    }
}
