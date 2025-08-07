package com.dchans.api.admin.service.reservation.impl;

import com.dchans.api.admin.dao.reservation.ReservationDao;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.reservation.ReservationDto;
import com.dchans.api.admin.service.reservation.ReservationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Resource(name = "ReservationDao")
    private ReservationDao reservationDao;

    private static final String NAMESPACE = "com.reservation.";

    @Override
    public PageResponse<ReservationDto.ReservationResponseDto> selectReservationList(ReservationDto.ReservationRequestDto requestDto) {
        try{
            List<ReservationDto.ReservationResponseDto> response = reservationDao.selectReservationList(NAMESPACE + "selectReservationList", requestDto);

            long totalCount = reservationDao.selectReservationCount(NAMESPACE + "selectReservationCount", requestDto);

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
        }catch (Exception e ){
            throw new RuntimeException("예약 목록 조회 중 오류가 발생했습니다.", e);
        }
    }

    @Override
    public ReservationDto.ReservationResponseDto selectReservationDetail(ReservationDto.ReservationRequestDto requestDto) {
        try{
            return reservationDao.selectReservationDetail(NAMESPACE + "selectReservationDetail", requestDto);
        }catch (Exception e ){
            throw new RuntimeException("예약 상세 조회 중 오류가 발생했습니다.", e);
        }
    }

    @Override
    public Integer updateReservation(ReservationDto.ReservationRequestDto requestDto) {
        try{
            return reservationDao.updateReservation(NAMESPACE + "updateReservation", requestDto);
        }catch (Exception e ){
            throw new RuntimeException("예약 상세 조회 중 오류가 발생했습니다.", e);
        }
    }
}
