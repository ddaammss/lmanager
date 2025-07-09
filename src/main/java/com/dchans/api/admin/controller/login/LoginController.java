package com.dchans.api.admin.controller.login;

import com.dchans.api.admin.dto.common.ApiResponseDto;
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
@RequestMapping("/admin/api/v1")
public class LoginController {

    private final LoginService loginService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto<LoginDto.LoginResponseDto>> login(@RequestBody LoginDto loginDto) {
        try {
            //return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(loginService.selectManagerOne(loginDto)));
            return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDto.error(200, "성공"));
        } catch (Exception e) {
            int code = 500;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponseDto.error(code, e.getMessage()));
        }
    }

}
