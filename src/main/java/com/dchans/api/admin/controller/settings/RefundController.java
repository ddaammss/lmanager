package com.dchans.api.admin.controller.settings;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.settings.policy.PolicyDto;
import com.dchans.api.admin.service.settings.policy.RefundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/settings/refund")
public class RefundController {

    private final RefundService refundService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<PolicyDto>> selectRefundDetail(@RequestBody PolicyDto requestDto) {
        PolicyDto responseDto = refundService.selectRefundDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/upsert")
    public ResponseEntity<ApiResponseDto<Integer>> upsertRefund(@RequestBody PolicyDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(refundService.upsertRefund(requestDto)));
    }
}