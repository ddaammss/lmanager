package com.dchans.api.admin.controller.settings;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.settings.policy.PolicyDto;
import com.dchans.api.admin.service.settings.policy.TermsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/settings/terms")
public class TermsController {

    private final TermsService termsService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public TermsController(TermsService termsService) {
        this.termsService = termsService;
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<PolicyDto>> selectTermsDetail(@RequestBody PolicyDto requestDto) {
        PolicyDto responseDto = termsService.selectTermsDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/upsert")
    public ResponseEntity<ApiResponseDto<Integer>> upsertTerms(@RequestBody PolicyDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(termsService.upsertTerms(requestDto)));
    }
}