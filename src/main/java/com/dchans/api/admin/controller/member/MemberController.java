package com.dchans.api.admin.controller.member;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.member.MemberDto;
import com.dchans.api.admin.service.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/member")
public class MemberController {
    private final MemberService memberService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<MemberDto.MemberResponseDto>> selectMemberList(@RequestBody MemberDto.MemberRequestDto requestDto) {
        PageResponse<MemberDto.MemberResponseDto> responseDto = memberService.selectMemberList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<MemberDto.MemberResponseDto>> selectMemberDetail(@RequestBody MemberDto.MemberRequestDto requestDto) {
        MemberDto.MemberResponseDto responseDto = memberService.selectMemberDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto<Integer>> updateMember(@RequestBody MemberDto.MemberUpdateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(memberService.updateMember(requestDto)));
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponseDto<Integer>> deleteMember(@RequestBody MemberDto.MemberDeleteDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(memberService.deleteMember(requestDto)));
    }
}