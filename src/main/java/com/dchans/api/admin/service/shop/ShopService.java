package com.dchans.api.admin.service.shop;

import com.dchans.api.admin.dto.shop.ShopDto;
import com.dchans.api.admin.dto.common.PageResponse;

public interface ShopService {


    PageResponse<ShopDto.ShopResponseDto> selectShopList(ShopDto.ShopRequestDto requestDto);

    ShopDto.ShopResponseDto selectShopDetail(ShopDto.ShopRequestDto requestDto);

    Integer insertShop(ShopDto.ShopCreateDto requestDto);

    Integer updateShop(ShopDto.ShopUpdateDto requestDto);

    Integer deleteShop(ShopDto.ShopDeleteDto requestDto);
}
