package com.dchans.api.admin.service.reservation;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.reservation.ReservationDto;
import com.dchans.api.admin.dto.settings.coupon.CouponDto;

public interface ReservationService {
    PageResponse<ReservationDto.ReservationResponseDto> selectReservationList(ReservationDto.ReservationRequestDto requestDto);

    ReservationDto.ReservationResponseDto selectReservationDetail(ReservationDto.ReservationRequestDto requestDto);

    Integer updateReservation(ReservationDto.ReservationRequestDto requestDto);
}
