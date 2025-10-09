package com.dchans.api.admin.controller.shop;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.event.EventDto;
import com.dchans.api.admin.dto.shop.ShopDto;
import com.dchans.api.admin.service.event.EventService;
import com.dchans.api.admin.service.shop.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/shop")
public class ShopController {
    private final ShopService shopService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ShopController(ShopService eventService) {
        this.shopService = eventService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<ShopDto.ShopResponseDto>> selectShopList(@RequestBody ShopDto.ShopRequestDto requestDto) {
        PageResponse<ShopDto.ShopResponseDto> responseDto = shopService.selectShopList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<ShopDto.ShopResponseDto>> selectShopDetail(@RequestBody ShopDto.ShopRequestDto requestDto) {
        ShopDto.ShopResponseDto responseDto = shopService.selectShopDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/insert")
    public ResponseEntity<ApiResponseDto<Integer>> insertShop(@RequestBody ShopDto.ShopCreateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(shopService.insertShop(requestDto)));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updateShop(@RequestBody ShopDto.ShopUpdateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(shopService.updateShop(requestDto)));
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponseDto<Integer>> deleteShop(@RequestBody ShopDto.ShopDeleteDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(shopService.deleteShop(requestDto)));
    }

}