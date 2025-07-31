package com.dchans.api.admin.service.settings.coupon;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.settings.coupon.CouponDto;

public interface CouponService {
    PageResponse<CouponDto.CouponResponseDto> selectCouponList(CouponDto.CouponRequestDto requestDto);

    Integer upsertCoupon(CouponDto.CouponCreateDto requestDto);
}
