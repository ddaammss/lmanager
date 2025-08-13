package com.dchans.api.admin.service.settings.policy;

import com.dchans.api.admin.dto.settings.policy.PolicyDto;

public interface PrivacyService {

    PolicyDto selectPrivacyDetail(PolicyDto requestDto);

    Integer upsertPrivacy(PolicyDto requestDto);
}
