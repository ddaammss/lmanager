package com.dchans.api.admin.service.member.impl;

import com.dchans.api.admin.dao.member.MemberDao;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.member.MemberDto;
import com.dchans.api.admin.service.member.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Resource(name = "MemberDao")
    private MemberDao memberDao ;

    private static final String NAMESPACE = "com.member.";

    @Override
    public PageResponse<MemberDto.MemberResponseDto> selectMemberList(MemberDto.MemberRequestDto requestDto) {
        List<MemberDto.MemberResponseDto> response = memberDao.selectMemberList(NAMESPACE + "selectMemberList", requestDto);

        long totalCount = memberDao.selectMemberCount(NAMESPACE + "selectMemberCount", requestDto);

        // 3. 페이징 정보 계산
        int totalPages = (int) Math.ceil((double) totalCount / requestDto.getPageSize());

        // 4. PageResponse 생성
        return new PageResponse<>(
                response,                    // 데이터 목록
                requestDto.getPage(),          // 현재 페이지
                totalPages,                    // 총 페이지 수
                totalCount,                    // 총 아이템 수
                requestDto.getPageSize()       // 페이지 크기
        );
    }

    @Override
    public MemberDto.MemberResponseDto selectMemberDetail(MemberDto.MemberRequestDto requestDto) {
        return memberDao.selectMemberDetail(NAMESPACE + "selectMemberDetail", requestDto);
    }

    @Override
    public Integer updateMember(MemberDto.MemberUpdateDto requestDto) {
        return memberDao.updateMember(NAMESPACE + "updateMember", requestDto);
    }

    @Override
    public Integer deleteMember(MemberDto.MemberDeleteDto requestDto) {
        return memberDao.deleteMember(NAMESPACE + "deleteMember", requestDto);
    }
}
