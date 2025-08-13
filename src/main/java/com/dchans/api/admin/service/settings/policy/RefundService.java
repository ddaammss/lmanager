package com.dchans.api.admin.service.settings.policy;

import com.dchans.api.admin.dto.settings.policy.PolicyDto;

public interface RefundService {

    PolicyDto selectRefundDetail(PolicyDto requestDto);

    Integer upsertRefund(PolicyDto requestDto);
}
