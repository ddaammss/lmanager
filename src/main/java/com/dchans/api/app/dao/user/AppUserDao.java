package com.dchans.api.app.dao.user;

import com.dchans.api.app.dto.user.AppUserDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("AppUserDao")
public class AppUserDao extends AbstractMapper {
    public AppUserDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public AppUserDto.UserResponseDto selectAppUserData(String s, AppUserDto.UserRequestDto requestDto) {
        return selectOne(s, requestDto);
    }


}
