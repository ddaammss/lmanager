package com.dchans.api.admin.service.settings.policy.impl;

import com.dchans.api.admin.dao.settings.policy.TermsDao;
import com.dchans.api.admin.dto.settings.policy.PolicyDto;
import com.dchans.api.admin.service.settings.policy.TermsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TermsServiceImpl implements TermsService {
    @Resource(name = "TermsDao")
    private TermsDao termsDao;

    private static final String NAMESPACE = "com.settings.policy.";

    @Override
    public PolicyDto selectTermsDetail(PolicyDto requestDto) {
        return termsDao.selectTermsDetail(NAMESPACE + "selectPolicyDetail", requestDto);
    }

    @Override
    public Integer upsertTerms(PolicyDto requestDto) {
        return termsDao.upsertTerms(NAMESPACE + "upsertPolicy", requestDto);
    }
}
