package com.dchans.api.admin.manager.contoller;

import com.dchans.api.admin.common.ApiResponse;
import com.dchans.api.admin.manager.dto.ManagerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerContoller {

    @GetMapping("/users/{id}")
    public ApiResponse<ManagerDto> getUser(@PathVariable Long id) {
        //ManagerDto user = userService.findById(id);
        //return ApiResponse.success(user);
        return null;
    }
}
