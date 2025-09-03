package com.dchans.api.admin.service.member;

import com.dchans.api.admin.dto.member.PointDto;

public interface PointService {

    PointDto.PointResponseDto selectPointSetting();

    Integer updatePoint(PointDto.PointUpdateDto requestDto);

}
