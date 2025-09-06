package com.dchans.api.admin.dao.ad;

import com.dchans.api.admin.dto.ad.AdDto;
import com.dchans.api.admin.dto.sales.SalesDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AdDao")
public class AdDao extends AbstractMapper {
    public AdDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<AdDto.AdResponseDto> selectAdRequestList(String s, AdDto.AdRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectAdRequestCount(String s, AdDto.AdRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public AdDto.AdResponseDto selectAdRequestDetail(String s, AdDto.AdRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer updateAdRequest(String s, AdDto.AdUpdateDto requestDto) {
        return insert(s, requestDto);
    }




    public List<AdDto.AdResponseDto> selectAdRegistList(String s, AdDto.AdRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectAdRegistCount(String s, AdDto.AdRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public AdDto.AdResponseDto selectAdRegistDetail(String s, AdDto.AdRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer upsertAdRegist(String s, AdDto.AdCreateDto requestDto) {
        return insert(s, requestDto);
    }
}
