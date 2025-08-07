package com.dchans.api.admin.service.reservation;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.reservation.ReservationDto;

public interface CancellationService {
    PageResponse<ReservationDto.ReservationResponseDto> selectCancellationList(ReservationDto.ReservationRequestDto requestDto);

    ReservationDto.ReservationResponseDto selectCancellationDetail(ReservationDto.ReservationRequestDto requestDto);

    Integer updateCancellation(ReservationDto.ReservationRequestDto requestDto);
}
