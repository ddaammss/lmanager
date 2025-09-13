package com.dchans.api.admin.dao.event;

import com.dchans.api.admin.dto.event.BannerDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BannerDao")
public class BannerDao extends AbstractMapper {
    public BannerDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public BannerDto.BannerResponseDto selectMainBanner(String s, BannerDto.BannerRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public List<String> selectMainBannerImageList(String s, BannerDto.BannerRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public Integer insertBanner(String s, BannerDto.BannerCreateDto requestDto) {
        return insert(s, requestDto);
    }

    public Integer updateBanner(String s, BannerDto.BannerUpdateDto requestDto) {
        return update(s, requestDto);
    }
}
