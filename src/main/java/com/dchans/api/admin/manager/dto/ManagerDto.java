package com.dchans.api.admin.manager.dto;

import java.time.LocalDateTime;

public record ManagerDto(
        Long id,
        String username,
        String email,
        String name,
        String role,
        boolean active,
        LocalDateTime lastLoginAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
