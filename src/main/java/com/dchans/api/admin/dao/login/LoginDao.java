package com.dchans.api.admin.dao.login;

import com.dchans.api.common.AbstractMapper;
import com.dchans.api.admin.dto.login.LoginDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("LoginDao")
public class LoginDao extends AbstractMapper {
    public LoginDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public LoginDto.LoginResponseDto selectManagerOne(String queryId, LoginDto.LoginRequestDto requestDto) {
        return selectOne(queryId, requestDto);
    }
}
