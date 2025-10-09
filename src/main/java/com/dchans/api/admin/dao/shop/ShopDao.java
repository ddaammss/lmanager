package com.dchans.api.admin.dao.shop;

import com.dchans.api.admin.dto.shop.ShopDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ShopDao")
public class ShopDao extends AbstractMapper {
    public ShopDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<ShopDto.ShopResponseDto> selectShopList(String s, ShopDto.ShopRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectShopCount(String s, ShopDto.ShopRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public ShopDto.ShopResponseDto selectShopDetail(String s, ShopDto.ShopRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public List<String> selectShopImageList(String s, ShopDto.ShopRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public Integer insertShop(String s, ShopDto.ShopCreateDto requestDto) {
        return insert(s, requestDto);
    }

    public Integer updateShop(String s, ShopDto.ShopUpdateDto requestDto) {
        return update(s, requestDto);
    }

    public Integer deleteShop(String s, ShopDto.ShopDeleteDto requestDto) {
        return delete(s, requestDto);
    }
}
