package com.dchans.api.admin.dao.event;

import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.dchans.api.admin.dto.event.CommunicationDto;

import java.util.List;

@Repository("CommunicationDao")
public class CommunicationDao extends AbstractMapper {
    public CommunicationDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<CommunicationDto.CommunicationResponseDto> selectCommunicationList(String s, CommunicationDto.CommunicationRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectCommunicationCount(String s, CommunicationDto.CommunicationRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public CommunicationDto.CommunicationResponseDto selectCommunicationDetail(String s, CommunicationDto.CommunicationRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public Integer updateCommunication(String s, CommunicationDto.CommunicationUpdateDto requestDto) {
        return update(s, requestDto);
    }

}
