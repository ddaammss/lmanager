package com.dchans.api.admin.service.store;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.settings.coupon.CouponDto;
import com.dchans.api.admin.dto.store.StoreDto;

public interface StoreService {
    PageResponse<StoreDto.StoreResponseDto> selectStoreList(StoreDto.StoreRequestDto requestDto);

    StoreDto.StoreResponseDto selectStoreDetail(StoreDto.StoreRequestDto requestDto);

    Integer upsertStore(StoreDto.StoreCreateDto requestDto);

    Integer deleteStore(StoreDto.StoreDeleteDto requestDto);
}
