package com.dchans.api.admin.service.settings.policy.impl;

import com.dchans.api.admin.dao.settings.policy.RefundDao;
import com.dchans.api.admin.dto.settings.policy.PolicyDto;
import com.dchans.api.admin.service.settings.policy.RefundService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RefundServiceImpl implements RefundService {
    @Resource(name = "RefundDao")
    private RefundDao refundDao;

    private static final String NAMESPACE = "com.settings.policy.";

    @Override
    public PolicyDto selectRefundDetail(PolicyDto requestDto) {
        return refundDao.selectRefundDetail(NAMESPACE + "selectPolicyDetail", requestDto);
    }

    @Override
    public Integer upsertRefund(PolicyDto requestDto) {
        return refundDao.upsertRefund(NAMESPACE + "upsertPolicy", requestDto);
    }
}
