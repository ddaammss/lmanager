package com.dchans.api.admin.controller.login;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.jwt.TokenResponseDto;
import com.dchans.api.admin.dto.login.LoginDto;
import com.dchans.api.admin.service.login.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
public class LoginController {

    private final LoginService loginService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto<TokenResponseDto>> login(@RequestBody LoginDto.LoginRequestDto requestDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDto.success(loginService.selectManagerOne(requestDto)));
        } catch (Exception e) {
            int code = 500;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponseDto.error(code, e.getMessage()));
        }
    }

}
