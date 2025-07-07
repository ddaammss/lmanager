package com.dchans.api.admin.dao.login;

import com.dchans.api.common.AbstractMapper;
import com.dchans.api.admin.dto.login.LoginDto;
import com.dchans.api.admin.entity.login.ManagerEntity;
import org.springframework.stereotype.Repository;

@Repository("LoginDao")
public class LoginDao extends AbstractMapper {
    public ManagerEntity selectManagerOne(String queryId, LoginDto loginDto) {
        return selectOne(queryId, loginDto);
    }
}
