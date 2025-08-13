package com.dchans.api.admin.service.settings.policy;

import com.dchans.api.admin.dto.settings.policy.PolicyDto;

public interface TermsService {

    PolicyDto selectTermsDetail(PolicyDto requestDto);

    Integer upsertTerms(PolicyDto requestDto);
}
