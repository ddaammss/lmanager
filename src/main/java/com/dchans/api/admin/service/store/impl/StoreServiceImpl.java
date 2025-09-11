package com.dchans.api.admin.service.store.impl;

import com.dchans.api.admin.dao.store.StoreDao;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.store.StoreDto;
import com.dchans.api.admin.service.store.StoreService;
import jakarta.annotation.Resource;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Resource(name = "StoreDao")
    private StoreDao storeDao;

    private static final String NAMESPACE = "com.store.";

    @Override
    public PageResponse<StoreDto.StoreResponseDto> selectStoreList(StoreDto.StoreRequestDto requestDto) {
        List<StoreDto.StoreResponseDto> response = storeDao.selectStoreList(NAMESPACE + "selectStoreList", requestDto);

        long totalCount = storeDao.selectStoreCount(NAMESPACE + "selectStoreCount", requestDto);

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
    public StoreDto.StoreResponseDto selectStoreDetail(StoreDto.StoreRequestDto requestDto) {
        StoreDto.StoreResponseDto detail = storeDao.selectStoreDetail(NAMESPACE + "selectStoreDetail", requestDto);
        List<StoreDto.StoreProductDto> storeProductList = storeDao.selectStoreProductList(NAMESPACE + "selectStoreProductList", requestDto);
        List<String> storeImageList = storeDao.selectStoreImageList(NAMESPACE + "selectStoreImageList", requestDto);
        detail.setProducts(storeProductList);
        detail.setImages(storeImageList);
        return detail;
    }

    @Override
    @Transactional
    public Integer upsertStore(StoreDto.StoreCreateDto requestDto) {
        List<StoreDto.StoreProductDto> storeProduct = new ArrayList<>();
        for (StoreDto.StoreProductDto var : requestDto.getProducts()) {
            StoreDto.StoreProductDto storeProductDto = new StoreDto.StoreProductDto();
            storeProductDto.setParentSeq(requestDto.getSeq());
            storeProductDto.setName(var.getName());
            storeProductDto.setPrice(var.getPrice());
            storeProduct.add(storeProductDto);
        }
        storeDao.deleteStoreProduct(NAMESPACE + "deleteStoreProduct", requestDto);
        storeDao.insertStoreProduct(NAMESPACE + "insertStoreProduct", storeProduct);

        return storeDao.upsertStore(NAMESPACE + "upsertStore", requestDto);
    }

    @Override
    public Integer deleteStore(StoreDto.StoreDeleteDto requestDto) {
        return storeDao.deleteStore(NAMESPACE + "deleteStore", requestDto);
    }
}
