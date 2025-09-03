package com.dchans.api.admin.dto.member;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record MemberDto(
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
    public static class MemberRequestDto {
        private String type1;
        private String type2;
        private String name;
        private String startDate;
        private String endDate;
        private String orderType;
        private String memberType;
        private String gender;
        private int page = 1;        // 요청 페이지 (1부터 시작)
        private int pageSize = 10;   // 페이지당 개수
        private int offset;

        private String memberId;

        public int getOffset() {
            return (page - 1) * pageSize;
        }
    }

    @Getter
    @Setter
    public static class MemberResponseDto {
        private Long seq;
        private String memberId;
        private String memberName;
        private Integer gender;
        private Integer memberType;
        private String nickName;
        private String age;
        private String region;
        private String emoney;
        private String point;
        private String phone;
        private String email;
        private String lastLoginAt;
        private String loginCount;
        private String createdAt;

        private String genderNm;
        private String memberTypeNm;
    }

    @Getter
    @Setter
    public static class MemberUpdateDto {
        private String id;
        private String memberId;
        private String memberType;
    }

    @Getter
    @Setter
    public static class MemberDeleteDto {
        private List<String> memberIdList;
    }


}