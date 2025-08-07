package com.dchans.api.admin.dao.reservation;

import com.dchans.api.admin.dto.reservation.ReservationDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CancellationDao")
public class CancellationDao extends AbstractMapper {
    public CancellationDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<ReservationDto.ReservationResponseDto> selectCancellationList(String s, ReservationDto.ReservationRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectCancellationCount(String s, ReservationDto.ReservationRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public ReservationDto.ReservationResponseDto selectCancellationDetail(String s, ReservationDto.ReservationRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer updateCancellation(String s, ReservationDto.ReservationRequestDto requestDto) {
        return update(s, requestDto);
    }
}
