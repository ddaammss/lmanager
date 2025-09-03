package com.dchans.api.admin.service.member;

import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.member.MemberDto;
import com.dchans.api.admin.dto.reservation.ReservationDto;
public interface MemberService {
    PageResponse<MemberDto.MemberResponseDto> selectMemberList(MemberDto.MemberRequestDto requestDto);

    MemberDto.MemberResponseDto selectMemberDetail(MemberDto.MemberRequestDto requestDto);

    Integer updateMember(MemberDto.MemberUpdateDto requestDto);

    Integer deleteMember(MemberDto.MemberDeleteDto requestDto);
}
