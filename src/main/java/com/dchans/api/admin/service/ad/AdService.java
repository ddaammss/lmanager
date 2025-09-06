package com.dchans.api.admin.service.ad;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.ad.AdDto;

public interface AdService {
    PageResponse<AdDto.AdResponseDto> selectAdRequestList(AdDto.AdRequestDto requestDto);

    AdDto.AdResponseDto selectAdRequestDetail(AdDto.AdRequestDto requestDto);

    Integer updateAdRequest(AdDto.AdUpdateDto requestDto);

    PageResponse<AdDto.AdResponseDto> selectAdRegistList(AdDto.AdRequestDto requestDto);

    AdDto.AdResponseDto selectAdRegistDetail(AdDto.AdRequestDto requestDto);

    Integer upsertAdRegist(AdDto.AdCreateDto requestDto);
}
