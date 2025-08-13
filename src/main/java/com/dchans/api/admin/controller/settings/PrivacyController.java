package com.dchans.api.admin.controller.settings;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.settings.policy.PolicyDto;
import com.dchans.api.admin.service.settings.policy.PrivacyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/settings/privacy")
public class PrivacyController {

    private final PrivacyService privacyService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public PrivacyController(PrivacyService privacyService) {
        this.privacyService = privacyService;
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<PolicyDto>> selectPrivacyDetail(@RequestBody PolicyDto requestDto) {
        PolicyDto responseDto = privacyService.selectPrivacyDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/upsert")
    public ResponseEntity<ApiResponseDto<Integer>> upsertPrivacy(@RequestBody PolicyDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(privacyService.upsertPrivacy(requestDto)));
    }
}