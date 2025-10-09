package com.dchans.api.admin.service.shop.impl;

import com.dchans.api.admin.dao.shop.ShopDao;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.shop.ShopDto;
import com.dchans.api.admin.service.shop.ShopService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Resource(name = "ShopDao")
    private ShopDao shopDao;

    private static final String NAMESPACE = "com.shop.";

    @Override
    public PageResponse<ShopDto.ShopResponseDto> selectShopList(ShopDto.ShopRequestDto requestDto) {
        List<ShopDto.ShopResponseDto> response = shopDao.selectShopList(NAMESPACE + "selectShopList", requestDto);

        long totalCount = shopDao.selectShopCount(NAMESPACE + "selectShopCount", requestDto);

        // 3. 페이징 정보 계산
        int totalPages = (int) Math.ceil((double) totalCount / requestDto.getPageSize());

        // 4. PageResponse 생성
        return new PageResponse<>(
                response,                    // 데이터 목록
                requestDto.getPage(),          // 현재 페이지
                totalPages,                    // 총 페이지 수
                totalCount,                    // 총 아이템 수
                requestDto.getPageSize()       // 페이지 크기
        );
    }

    @Override
    public ShopDto.ShopResponseDto selectShopDetail(ShopDto.ShopRequestDto requestDto) {
        ShopDto.ShopResponseDto detail = shopDao.selectShopDetail(NAMESPACE + "selectShopDetail", requestDto);
        List<String> storeImageList = shopDao.selectShopImageList(NAMESPACE + "selectShopImageList", requestDto);
        detail.setImages(storeImageList);
        return detail;
    }

    @Override
    public Integer insertShop(ShopDto.ShopCreateDto requestDto) {
        shopDao.insertShop(NAMESPACE + "insertShop", requestDto);
        return Integer.parseInt(requestDto.getSeq());
    }

    @Override
    public Integer updateShop(ShopDto.ShopUpdateDto requestDto) {
        return shopDao.updateShop(NAMESPACE + "updateShop", requestDto);
    }

    @Override
    public Integer deleteShop(ShopDto.ShopDeleteDto requestDto) {
        return shopDao.deleteShop(NAMESPACE + "deleteShop", requestDto);
    }
}
