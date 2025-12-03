package com.dchans.api.app.dao.user;

import com.dchans.api.app.dto.point.AppPointDto;
import com.dchans.api.app.dto.user.AppUserDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AppUserDao")
public class AppUserDao extends AbstractMapper {
    public AppUserDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public AppUserDto.UserResponseDto selectAppUserData(String s, AppUserDto.UserRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public int updateUser(String s, AppUserDto.UserRequestDto requestDto) {
        return update(s, requestDto);
    }

    public List<AppPointDto.PointResponseDto> selectAppUserPointData(String s, AppPointDto.PointRequestDto requestDto) {
        return selectList(s, requestDto);
    }
}
