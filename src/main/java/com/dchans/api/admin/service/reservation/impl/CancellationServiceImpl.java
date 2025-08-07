package com.dchans.api.admin.service.reservation.impl;

import com.dchans.api.admin.dao.reservation.CancellationDao;
import com.dchans.api.admin.dao.reservation.ReservationDao;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.reservation.ReservationDto;
import com.dchans.api.admin.service.reservation.CancellationService;
import com.dchans.api.admin.service.reservation.ReservationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancellationServiceImpl implements CancellationService {
    @Resource(name = "CancellationDao")
    private CancellationDao cancellationDao;

    private static final String NAMESPACE = "com.cancellation.";

    @Override
    public PageResponse<ReservationDto.ReservationResponseDto> selectCancellationList(ReservationDto.ReservationRequestDto requestDto) {
        List<ReservationDto.ReservationResponseDto> response = cancellationDao.selectCancellationList(NAMESPACE + "selectCancellationList", requestDto);

        long totalCount = cancellationDao.selectCancellationCount(NAMESPACE + "selectCancellationCount", requestDto);

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
    public ReservationDto.ReservationResponseDto selectCancellationDetail(ReservationDto.ReservationRequestDto requestDto) {
        return cancellationDao.selectCancellationDetail(NAMESPACE + "selectCancellationDetail", requestDto);
    }

    @Override
    public Integer updateCancellation(ReservationDto.ReservationRequestDto requestDto) {
        return cancellationDao.updateCancellation(NAMESPACE + "updateCancellation", requestDto);
    }
}
