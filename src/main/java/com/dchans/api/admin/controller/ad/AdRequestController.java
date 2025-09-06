package com.dchans.api.admin.controller.ad;

import com.dchans.api.admin.dto.ad.AdDto;
import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.service.ad.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/ad/request")
public class AdRequestController {

    private final AdService adService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AdRequestController(AdService adService) {
        this.adService = adService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<AdDto.AdResponseDto>> selectAdRequestList(@RequestBody AdDto.AdRequestDto requestDto) {
        PageResponse<AdDto.AdResponseDto> responseDto = adService.selectAdRequestList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<AdDto.AdResponseDto>> selectAdRequestDetail(@RequestBody AdDto.AdRequestDto requestDto) {
        AdDto.AdResponseDto responseDto = adService.selectAdRequestDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updateAdRequest(@RequestBody AdDto.AdUpdateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(adService.updateAdRequest(requestDto)));
    }
}