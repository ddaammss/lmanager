package com.dchans.api.app.dao.login;

import com.dchans.api.app.dto.login.AppNaverDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("AppLoginDao")
public class AppLoginDao extends AbstractMapper {
    public AppLoginDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public AppNaverDto.NaverLoginResponseDto selectNaverUserData(String s, AppNaverDto.NaverLoginRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public void insertNaverUserData(String s, AppNaverDto.NaverLoginRequestDto requestDto) {
        insert(s, requestDto);
    }

    public AppNaverDto.NaverLoginResponseDto selectKakaoUserData(String s, AppNaverDto.NaverLoginRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public void insertKakaoUserData(String s, AppNaverDto.NaverLoginRequestDto requestDto) {
        insert(s, requestDto);
    }
}
