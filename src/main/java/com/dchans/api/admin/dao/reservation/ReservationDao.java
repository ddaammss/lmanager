package com.dchans.api.admin.dao.reservation;

import com.dchans.api.admin.dto.reservation.ReservationDto;
import com.dchans.api.admin.dto.settings.coupon.CouponDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ReservationDao")
public class ReservationDao extends AbstractMapper {
    public ReservationDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<ReservationDto.ReservationResponseDto> selectReservationList(String s, ReservationDto.ReservationRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectReservationCount(String s, ReservationDto.ReservationRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public ReservationDto.ReservationResponseDto selectReservationDetail(String s, ReservationDto.ReservationRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer updateReservation(String s, ReservationDto.ReservationRequestDto requestDto) {
        return update(s, requestDto);
    }

    public Integer deleteReservation(String s, ReservationDto.ReservationDeleteDto requestDto) {
        return delete(s, requestDto);
    }
}
