package com.dchans.api.admin.dto.manager;

public record ManagerDto(
        String id,
        String name,
        String email,
        String role,
        boolean active
        //LocalDateTime lastLoginAt,
        //LocalDateTime createdAt,
        //LocalDateTime updatedAt
) {

}
