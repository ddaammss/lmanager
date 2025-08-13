package com.dchans.api.admin.service.settings.policy.impl;

import com.dchans.api.admin.dao.settings.policy.PrivacyDao;
import com.dchans.api.admin.dto.settings.policy.PolicyDto;
import com.dchans.api.admin.service.settings.policy.PrivacyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PrivacyServiceImpl implements PrivacyService {
    @Resource(name = "PrivacyDao")
    private PrivacyDao privacyDao;

    private static final String NAMESPACE = "com.settings.policy.";

    @Override
    public PolicyDto selectPrivacyDetail(PolicyDto requestDto) {
        return privacyDao.selectPrivacyDetail(NAMESPACE + "selectPolicyDetail", requestDto);
    }

    @Override
    public Integer upsertPrivacy(PolicyDto requestDto) {
        return privacyDao.upsertPrivacy(NAMESPACE + "upsertPolicy", requestDto);
    }
}
