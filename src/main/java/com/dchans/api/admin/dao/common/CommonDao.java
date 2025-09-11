package com.dchans.api.admin.dao.common;

import com.dchans.api.admin.dto.common.ImageDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("CommonDao")
public class CommonDao extends AbstractMapper {
    public CommonDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public void deleteImage(String s, ImageDto requestDto) {
        delete(s, requestDto);
    }

    public void insertImage(String s, ImageDto requestDto) {
        insert(s, requestDto);
    }
}
