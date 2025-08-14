package com.dchans.api.admin.dao.store;

import com.dchans.api.admin.dto.store.StoreDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StoreDao")
public class StoreDao extends AbstractMapper {
    public StoreDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<StoreDto.StoreResponseDto> selectStoreList(String s, StoreDto.StoreRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectStoreCount(String s, StoreDto.StoreRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public StoreDto.StoreResponseDto selectStoreDetail(String s, StoreDto.StoreRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer upsertStore(String s, StoreDto.StoreCreateDto requestDto) {
        return insert(s, requestDto);
    }

    public Integer deleteStore(String s, StoreDto.StoreDeleteDto requestDto) {
        return delete(s, requestDto);
    }
}
