package com.dchans.api.admin.dto.settings.coupon;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CouponDto(
        Long id,
        String couponCode,
        String couponName,
        Integer category,
        String categoryName,  // 변환된 카테고리명
        Integer couponType,
        String typeName,      // 변환된 타입명
        BigDecimal discountValue,
        String discountDisplay,  // 표시용 할인값 (10% 또는 5000원)
        BigDecimal maxDiscountAmount,
        BigDecimal minOrderAmount,
        Integer issueType,
        String issueTypeName,  // 변환된 발급타입명
        Integer maxIssueCount,
        Integer maxIssuePerUser,
        Integer maxUseCount,
        Integer useLimitDays,
        LocalDate startDate,
        LocalDate endDate,
        Integer status,
        String statusName,    // 변환된 상태명
        Boolean isActive,
        String activeName,    // 변환된 활성상태명
        Boolean isDuplicable,
        Boolean isStackable,
        String description,
        String termsConditions,
        String memo,
        Long createdBy,
        Long updatedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,

        // 통계 정보 (선택사항)
        Long useCount,        // 사용 건수
        Long issueCount,      // 발급 건수
        BigDecimal totalDiscountAmount  // 총 할인 금액
) {
    @Getter
    @Setter
    public static class CouponRequestDto {
        private String startDate;
        private String endDate;
        private String category;
        private String status;
        private String couponCode;
        private int page = 1;        // 요청 페이지 (1부터 시작)
        private int pageSize = 10;   // 페이지당 개수
        private int offset;

        public int getOffset() {
            return (page - 1) * pageSize;
        }
    }

    @Getter
    @Setter
    public static class CouponResponseDto {
        private Long id;
        private String couponCode;
        private String couponName;
        private Integer category;
        private String categoryName;  // 변환된 카테고리명
        private Integer couponType;
        private String typeName;      // 변환된 타입명
        private String discountValue;
        private String discountDisplay;  // 표시용 할인값 (10% 또는 5000원)
        private String maxDiscountAmount;
        private String minOrderAmount;
        private Integer issueType;
        private String issueTypeName;  // 변환된 발급타입명
        private String maxIssueCount;
        private Integer maxIssuePerUser;
        private Integer maxUseCount;
        private Integer useLimitDays;
        private LocalDate issueDate;
        private LocalDate startDate;
        private LocalDate endDate;
        private String expireDate;
        private Integer status;
        private String statusName;    // 변환된 상태명
        private Boolean isActive;
        private String activeName;    // 변환된 활성상태명
        private Boolean isDuplicable;
        private Boolean isStackable;
        private String description;
        private String termsConditions;
        private String memo;
        private Long createdBy;
        private Long updatedBy;
        private String createdAt;
        private String updatedAt;

        // 통계 정보 (선택사항)
        private Long useCount;        // 사용 건수
        private Long issueCount;      // 발급 건수
        private BigDecimal totalDiscountAmount;  // 총 할인 금액
    }

    @Getter
    @Setter
    public static class CouponCreateDto {
        private String category;
        private String couponCode;
        private String couponName;
        private String couponType;
        private String discountValue;
        private String maxDiscountAmount;
        private String maxIssueCount;
        private String minOrderAmount;
        private String issueDate;
        private String startDate;
        private String endDate;
        private String status;

    }

    @Getter
    @Setter
    public static class CouponDeleteDto {
        private List<String> couponCodeList;

    }

}