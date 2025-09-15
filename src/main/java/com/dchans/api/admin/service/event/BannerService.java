package com.dchans.api.admin.service.event;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.event.BannerDto;
import com.dchans.api.admin.dto.event.EventDto;

public interface BannerService {

    BannerDto.BannerResponseDto selectMainBanner(BannerDto.BannerRequestDto requestDto);


    Integer insertBanner(BannerDto.BannerCreateDto requestDto);

    Integer updateBanner(BannerDto.BannerUpdateDto requestDto);


}
