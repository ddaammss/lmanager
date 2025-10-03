package com.dchans.api.admin.service.sales;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.sales.SalesDto;

public interface SalesService {
    PageResponse<SalesDto.SalesResponseDto> selectSalesList(SalesDto.SalesRequestDto requestDto);

    SalesDto.SalesResponseDto selectSalesDetail(SalesDto.SalesRequestDto requestDto);

    PageResponse<SalesDto.SalesResponseDto> selectStoreList(SalesDto.SalesRequestDto requestDto);

    Integer upsertSales(SalesDto.SalesCreateDto requestDto);


}
