package com.dchans.api.admin.controller.reservation;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.reservation.ReservationDto;
import com.dchans.api.admin.service.reservation.CancellationService;
import com.dchans.api.admin.service.reservation.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/cancellation")
public class CancellationController {

    private final CancellationService cancellationService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CancellationController(CancellationService cancellationService) {
        this.cancellationService = cancellationService;
    }


    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<ReservationDto.ReservationResponseDto>> selectCancellationList(@RequestBody ReservationDto.ReservationRequestDto requestDto) {
        PageResponse<ReservationDto.ReservationResponseDto> responseDto = cancellationService.selectCancellationList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<ReservationDto.ReservationResponseDto>> selectCancellationDetail(@RequestBody ReservationDto.ReservationRequestDto requestDto) {
        ReservationDto.ReservationResponseDto responseDto = cancellationService.selectCancellationDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updateCancellation(@RequestBody ReservationDto.ReservationRequestDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(cancellationService.updateCancellation(requestDto)));
    }

}