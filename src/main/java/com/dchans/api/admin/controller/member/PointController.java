package com.dchans.api.admin.controller.member;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.member.PointDto;
import com.dchans.api.admin.service.member.PointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/point")
public class PointController {
    private final PointService pointService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping("/setting")
    public ResponseEntity<ApiResponseDto<PointDto.PointResponseDto>> selectPointSetting() {
        PointDto.PointResponseDto responseDto = pointService.selectPointSetting();
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updatePoint(@RequestBody PointDto.PointUpdateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(pointService.updatePoint(requestDto)));
    }

}