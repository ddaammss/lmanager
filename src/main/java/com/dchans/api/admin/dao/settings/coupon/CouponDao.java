package com.dchans.api.admin.dao.settings.coupon;

import com.dchans.api.admin.dto.settings.coupon.CouponDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CouponDao")
public class CouponDao extends AbstractMapper {
    public CouponDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<CouponDto.CouponResponseDto> selectCouponList(String s, CouponDto.CouponRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectCouponCount(String s, CouponDto.CouponRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer upsertCoupon(String s, CouponDto.CouponCreateDto requestDto) {
        return insert(s, requestDto);
    }
}
