package com.dchans.api.app.controller.login;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.login.AppNaverDto;
import com.dchans.api.app.service.login.AppLoginService;
import com.dchans.api.common.JwtTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api")
public class AppLoginController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final AppLoginService appLoginService;
    private final JwtTokenService jwtTokenService;

    public AppLoginController(AppLoginService appLoginService, JwtTokenService jwtTokenService) {
        this.appLoginService = appLoginService;
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/naver_login")
    public ResponseEntity<ApiResponseDto<AppNaverDto>> naverLoginProcess(@RequestBody AppNaverDto appNaverDto) {
        AppNaverDto naverDto = appLoginService.selectNaverUserData(appNaverDto);
        if (naverDto == null) {
            appLoginService.insertNaverUserData(appNaverDto);
        }
        appNaverDto.setJwtToken(jwtTokenService.generateAccessToken(appNaverDto.getName(), "MEMBER"));

        return ResponseEntity.ok(ApiResponseDto.success(appNaverDto));
    }

}
