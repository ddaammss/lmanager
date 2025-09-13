package com.dchans.api.admin.service.event;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.event.EventDto;

public interface EventService {


    PageResponse<EventDto.EventResponseDto> selectEventList(EventDto.EventRequestDto requestDto);

    EventDto.EventResponseDto selectEventDetail(EventDto.EventRequestDto requestDto);

    Integer insertEvent(EventDto.EventCreateDto requestDto);

    Integer updateEvent(EventDto.EventUpdateDto requestDto);

    Integer deleteEvent(EventDto.EventDeleteDto requestDto);
}
