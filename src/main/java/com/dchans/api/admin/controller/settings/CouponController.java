package com.dchans.api.admin.controller.settings;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.settings.coupon.CouponDto;
import com.dchans.api.admin.service.settings.coupon.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/settings/coupon")
public class CouponController {

    private final CouponService couponService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<CouponDto.CouponResponseDto>> selectCouponList(@RequestBody CouponDto.CouponRequestDto requestDto) {
        PageResponse<CouponDto.CouponResponseDto> responseDto = couponService.selectCouponList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<CouponDto.CouponResponseDto>> selectCouponDetail(@RequestBody CouponDto.CouponRequestDto requestDto) {
        CouponDto.CouponResponseDto responseDto = couponService.selectCouponDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/upsert")
    public ResponseEntity<ApiResponseDto<Integer>> upsertCoupon(@RequestBody CouponDto.CouponCreateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(couponService.upsertCoupon(requestDto)));
    }

//
//    @GetMapping("/{id}")
//    public ResponseEntity<CouponSettingsDto> getCouponSettingsById(@PathVariable Long id) {
//        return ResponseEntity.ok(couponSettingsService.getCouponSettingsById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<CouponSettingsDto> createCouponSettings(
//            @Valid @RequestBody CreateCouponSettingsRequest request) {
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(couponSettingsService.createCouponSettings(request));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CouponSettingsDto> updateCouponSettings(
//            @PathVariable Long id,
//            @Valid @RequestBody UpdateCouponSettingsRequest request) {
//        return ResponseEntity.ok(couponSettingsService.updateCouponSettings(id, request));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCouponSettings(@PathVariable Long id) {
//        couponSettingsService.deleteCouponSettings(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PatchMapping("/{id}/status")
//    public ResponseEntity<CouponSettingsDto> updateCouponStatus(
//            @PathVariable Long id,
//            @RequestParam Integer status) {
//        return ResponseEntity.ok(couponSettingsService.updateCouponStatus(id, status));
//    }
//
//    @GetMapping("/categories")
//    public ResponseEntity<List<CategoryDto>> getCouponCategories() {
//        return ResponseEntity.ok(couponSettingsService.getCouponCategories());
//    }
}