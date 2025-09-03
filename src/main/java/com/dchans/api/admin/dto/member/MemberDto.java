package com.dchans.api.admin.dto.member;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record MemberDto(
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