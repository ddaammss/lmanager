package com.dchans.api.admin.controller.event;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.event.BannerDto;
import com.dchans.api.admin.dto.event.EventDto;
import com.dchans.api.admin.service.event.BannerService;
import com.dchans.api.admin.service.event.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/banner")
public class BannerController {
    private final BannerService bannerService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @PostMapping("/main")
    public ResponseEntity<ApiResponseDto<BannerDto.BannerResponseDto>> selectMainBanner(@RequestBody BannerDto.BannerRequestDto requestDto) {
        BannerDto.BannerResponseDto responseDto = bannerService.selectMainBanner(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/sub")
    public ResponseEntity<ApiResponseDto<BannerDto.BannerResponseDto>> selectSubBanner(@RequestBody BannerDto.BannerRequestDto requestDto) {
        BannerDto.BannerResponseDto responseDto = bannerService.selectSubBanner(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }


    @PostMapping("/insert")
    public ResponseEntity<ApiResponseDto<Integer>> insertBanner(@RequestBody BannerDto.BannerCreateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(bannerService.insertBanner(requestDto)));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updateBanner(@RequestBody BannerDto.BannerUpdateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(bannerService.updateBanner(requestDto)));
    }
}