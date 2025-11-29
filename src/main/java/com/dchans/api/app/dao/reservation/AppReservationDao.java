package com.dchans.api.app.dao.reservation;

import com.dchans.api.app.dto.reservation.AppReservationDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppReservationDao")
public class AppReservationDao extends AbstractMapper {
    public AppReservationDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public AppReservationDto selectStoreReservationDetail(String s, AppReservationDto appReservationDto) {
        return selectOne(s, appReservationDto);
    }

    public List<AppReservationDto.ReverservationResponseDto> selectAppStoreMyReservationData(String s, AppReservationDto appReservationDto) {
        return selectList(s, appReservationDto);
    }
}
