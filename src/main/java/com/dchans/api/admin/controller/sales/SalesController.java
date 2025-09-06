package com.dchans.api.admin.controller.sales;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.sales.SalesDto;
import com.dchans.api.admin.service.sales.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/sales")
public class SalesController {

    private final SalesService salesService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<SalesDto.SalesResponseDto>> selectSalesList(@RequestBody SalesDto.SalesRequestDto requestDto) {
        PageResponse<SalesDto.SalesResponseDto> responseDto = salesService.selectSalesList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<SalesDto.SalesResponseDto>> selectSalesDetail(@RequestBody SalesDto.SalesRequestDto requestDto) {
        SalesDto.SalesResponseDto responseDto = salesService.selectSalesDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/upsert")
    public ResponseEntity<ApiResponseDto<Integer>> upsertSales(@RequestBody SalesDto.SalesCreateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(salesService.upsertSales(requestDto)));
    }
}