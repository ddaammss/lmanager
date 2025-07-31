package com.dchans.api.admin.service.settings.coupon.impl;

import com.dchans.api.admin.dao.settings.coupon.CouponDao;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.settings.coupon.CouponDto;
import com.dchans.api.admin.service.settings.coupon.CouponService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    @Resource(name = "CouponDao")
    private CouponDao couponDao;

    private static final String NAMESPACE = "com.settings.coupon.";

    @Override
    public PageResponse<CouponDto.CouponResponseDto> selectCouponList(CouponDto.CouponRequestDto requestDto) {
        List<CouponDto.CouponResponseDto> response = couponDao.selectCouponList(NAMESPACE + "selectCouponList", requestDto);

        long totalCount = couponDao.selectCouponCount(NAMESPACE + "selectCouponCount", requestDto);

        // 3. 페이징 정보 계산
        int totalPages = (int) Math.ceil((double) totalCount / requestDto.getPageSize());

        // 4. PageResponse 생성
        return new PageResponse<>(
                response,                    // 데이터 목록
                requestDto.getPage(),          // 현재 페이지
                totalPages,                    // 총 페이지 수
                totalCount,                    // 총 아이템 수
                requestDto.getPageSize()       // 페이지 크기
        );
    }

    @Override
    public Integer upsertCoupon(CouponDto.CouponCreateDto requestDto) {
        return couponDao.upsertCoupon(NAMESPACE + "upsertCoupon", requestDto);
    }
}
