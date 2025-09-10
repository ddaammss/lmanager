package com.dchans.api.admin.controller.event;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.event.EventDto;
import com.dchans.api.admin.service.event.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/event")
public class EventController {
    private final EventService eventService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<EventDto.EventResponseDto>> selectEventList(@RequestBody EventDto.EventRequestDto requestDto) {
        PageResponse<EventDto.EventResponseDto> responseDto = eventService.selectEventList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<EventDto.EventResponseDto>> selectEventDetail(@RequestBody EventDto.EventRequestDto requestDto) {
        EventDto.EventResponseDto responseDto = eventService.selectEventDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updateEvent(@RequestBody EventDto.EventUpdateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(eventService.updateEvent(requestDto)));
    }
}