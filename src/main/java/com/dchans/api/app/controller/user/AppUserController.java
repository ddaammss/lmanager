package com.dchans.api.app.controller.user;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.app.dto.event.AppEventDto;
import com.dchans.api.app.dto.user.AppUserDto;
import com.dchans.api.app.service.event.AppEventService;
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

//    private final AppEventService appEventService;
//
//    public AppUserController(AppEventService appEventService) {
//        this.appEventService = appEventService;
//    }

    /*@PostMapping("/info")
    public ResponseEntity<ApiResponseDto<AppUserDto>> selectAppEventListData(@RequestBody AppUserDto appEventDto) {
        AppEventDto eventDto = appEventService.selectAppEventListData(appEventDto);
        return ResponseEntity.ok(ApiResponseDto.success(eventDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<AppEventDto>> selectAppEventDetailData(@RequestBody AppEventDto appEventDto) {
        AppEventDto eventDto = appEventService.selectAppEventDetailData(appEventDto);
        return ResponseEntity.ok(ApiResponseDto.success(eventDto));
    }
*/

}
