package com.dchans.api.admin.service.sales.impl;

import com.dchans.api.admin.dao.Sales.SalesDao;
import com.dchans.api.admin.dao.store.StoreDao;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.sales.SalesDto;
import com.dchans.api.admin.dto.store.StoreDto;
import com.dchans.api.admin.service.sales.SalesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    @Resource(name = "SalesDao")
    private SalesDao  salesDao;

    private static final String NAMESPACE = "com.sales.";

    @Override
    public PageResponse<SalesDto.SalesResponseDto> selectSalesList(SalesDto.SalesRequestDto requestDto) {
        List<SalesDto.SalesResponseDto> response = salesDao.selectSalesList(NAMESPACE + "selectSalesList", requestDto);

        //long totalCount = salesDao.selectSalesCount(NAMESPACE + "selectSalesCount", requestDto);

        // 3. 페이징 정보 계산
        //int totalPages = (int) Math.ceil((double) totalCount / requestDto.getPageSize());

        // 4. PageResponse 생성
        return new PageResponse<>(
                response,                    // 데이터 목록
                requestDto.getPage(),          // 현재 페이지
                0,                    // 총 페이지 수
                0,                    // 총 아이템 수
                requestDto.getPageSize()       // 페이지 크기
        );
    }


    @Override
    public SalesDto.SalesResponseDto selectSalesDetail(SalesDto.SalesRequestDto requestDto) {
        return salesDao.selectSalesDetail(NAMESPACE + "selectSalesDetail", requestDto);
    }

    @Override
    public Integer upsertSales(SalesDto.SalesCreateDto requestDto) {
        return salesDao.upsertSales(NAMESPACE + "upsertSales", requestDto);
    }
}
