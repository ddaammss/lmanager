package com.dchans.api.admin.service.event;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.event.CommunicationDto;

public interface CommunicationService {


    PageResponse<CommunicationDto.CommunicationResponseDto> selectCommunicationList(CommunicationDto.CommunicationRequestDto requestDto);

    CommunicationDto.CommunicationResponseDto selectCommunicationDetail(CommunicationDto.CommunicationRequestDto requestDto);

    Integer updateCommunication(CommunicationDto.CommunicationUpdateDto requestDto);
}
