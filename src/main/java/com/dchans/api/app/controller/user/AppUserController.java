package com.dchans.api.app.controller.user;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.point.AppPointDto;
import com.dchans.api.app.dto.user.AppUserDto;
import com.dchans.api.app.service.user.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/api/user")
public class AppUserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/info")
    public ResponseEntity<ApiResponseDto<AppUserDto.UserResponseDto>> selectAppUserData(@RequestBody AppUserDto.UserRequestDto requestDto) {
        AppUserDto.UserResponseDto response = appUserService.selectAppUserData(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(response));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> selectAppUserUpdateData(@RequestBody AppUserDto.UserRequestDto requestDto) {
        int response = appUserService.updateUser(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(response));
    }

    @PostMapping("/point")
    public ResponseEntity<ApiResponseDto<AppPointDto>> selectAppUserPointData(@RequestBody AppPointDto.PointRequestDto requestDto) {
        AppPointDto response = appUserService.selectAppUserPointData(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(response));
    }

}
