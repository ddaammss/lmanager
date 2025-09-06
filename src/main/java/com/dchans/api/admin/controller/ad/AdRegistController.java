package com.dchans.api.admin.controller.ad;

import com.dchans.api.admin.dto.ad.AdDto;
import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.member.MemberDto;
import com.dchans.api.admin.service.ad.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/ad/regist")
public class AdRegistController {

    private final AdService adService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AdRegistController(AdService adService) {
        this.adService = adService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<AdDto.AdResponseDto>> selectAdRegistList(@RequestBody AdDto.AdRequestDto requestDto) {
        PageResponse<AdDto.AdResponseDto> responseDto = adService.selectAdRegistList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<AdDto.AdResponseDto>> selectAdRegistDetail(@RequestBody AdDto.AdRequestDto requestDto) {
        AdDto.AdResponseDto responseDto = adService.selectAdRegistDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updateAdRegist(@RequestBody AdDto.AdUpdateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(adService.updateAdRegist(requestDto)));
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponseDto<Integer>> deleteAdRegist(@RequestBody AdDto.AdDeleteDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(adService.deleteAdRegist(requestDto)));
    }

}