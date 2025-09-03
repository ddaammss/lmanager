package com.dchans.api.admin.controller.event;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.event.CommunicationDto;
import com.dchans.api.admin.service.event.CommunicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/communication")
public class CommunicationController {
    private final CommunicationService communicationService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<CommunicationDto.CommunicationResponseDto>> selectCommunicationList(@RequestBody CommunicationDto.CommunicationRequestDto requestDto) {
        PageResponse<CommunicationDto.CommunicationResponseDto> responseDto = communicationService.selectCommunicationList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<CommunicationDto.CommunicationResponseDto>> selectCommunicationDetail(@RequestBody CommunicationDto.CommunicationRequestDto requestDto) {
        CommunicationDto.CommunicationResponseDto responseDto = communicationService.selectCommunicationDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updateCommunication(@RequestBody CommunicationDto.CommunicationUpdateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(communicationService.updateCommunication(requestDto)));
    }
}