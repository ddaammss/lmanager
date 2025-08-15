package com.dchans.api.admin.dto.reservation;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ReservationDto(
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
    public static class ReservationRequestDto {
        private String type1;
        private String type2;
        private String name;
        private String startDate;
        private String endDate;
        private List<String> categoryType;
        private List<String> resultType;
        private String reservationType;
        private int page = 1;        // 요청 페이지 (1부터 시작)
        private int pageSize = 10;   // 페이지당 개수
        private int offset;

        private String reservationCode;


        public int getOffset() {
            return (page - 1) * pageSize;
        }
    }

    @Getter
    @Setter
    public static class ReservationResponseDto {
        private Long id;
        private String reservationCode;
        private String reserverName;
        private String reserverPhone;
        private String storeName; // 입점사명 (조인해서 가져올 경우)
        private LocalDate reservationDate;
        private LocalDate confirmDate;
        private Integer guestCount;
        private BigDecimal totalAmount;
        private String paymentAmount;
        private Integer categoryType;
        private String categoryTypeNm;
        private Integer resultType;
        private String resultTypeNm;
        private Integer reservationType;
        private String reservationTypeNm;
        private String cancelReason;
        private String createdAt;
        private String updatedAt;
        private String createdBy;
        private String updatedBy;
    }

    @Getter
    @Setter
    public static class ReservationUpdateDto {
        private String id;
        private String reservationCode;
        private String resultType;
        private String reservationType;
    }

    @Getter
    @Setter
    public static class ReservationDeleteDto {
        private List<String> reservationCodeList;
    }


}