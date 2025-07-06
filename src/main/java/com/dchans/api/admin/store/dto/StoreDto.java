package com.dchans.api.admin.store.dto;

import java.time.LocalDateTime;

public record StoreDto(
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
