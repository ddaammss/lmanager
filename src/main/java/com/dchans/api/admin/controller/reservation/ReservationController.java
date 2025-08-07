package com.dchans.api.admin.controller.reservation;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.reservation.ReservationDto;
import com.dchans.api.admin.dto.settings.coupon.CouponDto;
import com.dchans.api.admin.service.reservation.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<ReservationDto.ReservationResponseDto>> selectReservationList(@RequestBody ReservationDto.ReservationRequestDto requestDto) {
        PageResponse<ReservationDto.ReservationResponseDto> responseDto = reservationService.selectReservationList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<ReservationDto.ReservationResponseDto>> selectReservationDetail(@RequestBody ReservationDto.ReservationRequestDto requestDto) {
        ReservationDto.ReservationResponseDto responseDto = reservationService.selectReservationDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updateReservation(@RequestBody ReservationDto.ReservationRequestDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(reservationService.updateReservation(requestDto)));
    }

}