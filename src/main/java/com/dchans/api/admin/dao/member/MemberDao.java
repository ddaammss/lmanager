package com.dchans.api.admin.dao.member;

import com.dchans.api.admin.dto.member.MemberDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MemberDao")
public class MemberDao extends AbstractMapper {
    public MemberDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<MemberDto.MemberResponseDto> selectMemberList(String s, MemberDto.MemberRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectMemberCount(String s, MemberDto.MemberRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public MemberDto.MemberResponseDto selectMemberDetail(String s, MemberDto.MemberRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer updateMember(String s, MemberDto.MemberUpdateDto requestDto) {
        return update(s, requestDto);
    }

    public Integer deleteMember(String s, MemberDto.MemberDeleteDto requestDto) {
        return delete(s, requestDto);
    }
}
