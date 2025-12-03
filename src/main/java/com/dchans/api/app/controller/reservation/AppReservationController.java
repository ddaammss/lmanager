package com.dchans.api.app.controller.reservation;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.reservation.AppReservationDto;
import com.dchans.api.app.service.reservation.AppReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api")
public class AppReservationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AppReservationService appReservationService;

    public AppReservationController(AppReservationService appReservationService) {
        this.appReservationService = appReservationService;
    }

    @PostMapping("/reservation")
    public ResponseEntity<ApiResponseDto<AppReservationDto>> selectAppStoreReservationData(@RequestBody AppReservationDto appReservationDto) {
        AppReservationDto reservationDto = appReservationService.selectAppStoreReservationData(appReservationDto);
        return ResponseEntity.ok(ApiResponseDto.success(reservationDto));
    }

    @PostMapping("/my_reservation")
    public ResponseEntity<ApiResponseDto<AppReservationDto>> selectAppMyReservationData(@RequestBody AppReservationDto appReservationDto) {
        AppReservationDto reservationDto = appReservationService.selectAppMyReservationData(appReservationDto);
        return ResponseEntity.ok(ApiResponseDto.success(reservationDto));
    }

}
