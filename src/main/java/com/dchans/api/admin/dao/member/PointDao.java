package com.dchans.api.admin.dao.member;

import com.dchans.api.admin.dto.member.PointDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("PointDao")
public class PointDao extends AbstractMapper {
    public PointDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public PointDto.PointResponseDto selectPointSetting(String s) {
        return selectOne(s);
    }

    public Integer updatePoint(String s, PointDto.PointUpdateDto requestDto) {
        return update(s, requestDto);
    }

}
