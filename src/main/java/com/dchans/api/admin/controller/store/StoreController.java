package com.dchans.api.admin.controller.store;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.settings.coupon.CouponDto;
import com.dchans.api.admin.dto.store.StoreDto;
import com.dchans.api.admin.service.settings.coupon.CouponService;
import com.dchans.api.admin.service.store.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/store")
public class StoreController {

    private final StoreService storeService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<StoreDto.StoreResponseDto>> selectStoreList(@RequestBody StoreDto.StoreRequestDto requestDto) {
        PageResponse<StoreDto.StoreResponseDto> responseDto = storeService.selectStoreList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<StoreDto.StoreResponseDto>> selectCouponDetail(@RequestBody StoreDto.StoreRequestDto requestDto) {
        StoreDto.StoreResponseDto responseDto = storeService.selectStoreDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/upsert")
    public ResponseEntity<ApiResponseDto<Integer>> upsertCoupon(@RequestBody StoreDto.StoreCreateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(storeService.upsertStore(requestDto)));
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponseDto<Integer>> deleteCoupon(@RequestBody StoreDto.StoreDeleteDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(storeService.deleteStore(requestDto)));
    }
}