package com.dchans.api.app.controller.user;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.user.AppUserDto;
import com.dchans.api.app.service.user.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api/user")
public class AppUserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/info")
    public ResponseEntity<ApiResponseDto<AppUserDto.UserResponseDto>> selectAppUserData(@RequestBody AppUserDto.UserRequestDto appUserDto) {
        AppUserDto.UserResponseDto response = appUserService.selectAppUserData(appUserDto);
        return ResponseEntity.ok(ApiResponseDto.success(response));
    }

//    @PostMapping("/detail")
//    public ResponseEntity<ApiResponseDto<AppEventDto>> selectAppEventDetailData(@RequestBody AppEventDto appEventDto) {
//        AppEventDto eventDto = appEventService.selectAppEventDetailData(appEventDto);
//        return ResponseEntity.ok(ApiResponseDto.success(eventDto));
//    }

}
