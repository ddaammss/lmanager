package com.dchans.api.admin.dao.Sales;

import com.dchans.api.admin.dto.sales.SalesDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SalesDao")
public class SalesDao extends AbstractMapper {
    public SalesDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<SalesDto.SalesResponseDto> selectSalesList(String s, SalesDto.SalesRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectSalesCount(String s, SalesDto.SalesRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public SalesDto.SalesResponseDto selectSalesDetail(String s, SalesDto.SalesRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public List<SalesDto.SalesResponseDto> selectStoreList(String s, SalesDto.SalesRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public Integer upsertSales(String s, SalesDto.SalesCreateDto requestDto) {
        return insert(s, requestDto);
    }


}
