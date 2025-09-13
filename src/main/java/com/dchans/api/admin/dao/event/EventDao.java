package com.dchans.api.admin.dao.event;

import com.dchans.api.admin.dto.event.EventDto;
import com.dchans.api.admin.dto.store.StoreDto;
import com.dchans.api.common.AbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EventDao")
public class EventDao extends AbstractMapper {
    public EventDao(SqlSessionTemplate sqlSession) {
        super(sqlSession);
    }

    public List<EventDto.EventResponseDto> selectEventList(String s, EventDto.EventRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public int selectEventCount(String s, EventDto.EventRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public EventDto.EventResponseDto selectEventDetail(String s, EventDto.EventRequestDto requestDto) {
        return selectOne(s, requestDto);
    }

    public List<String> selectEventImageList(String s, EventDto.EventRequestDto requestDto) {
        return selectList(s, requestDto);
    }

    public Integer insertEvent(String s, EventDto.EventCreateDto requestDto) {
        return insert(s, requestDto);
    }

    public Integer updateEvent(String s, EventDto.EventUpdateDto requestDto) {
        return update(s, requestDto);
    }

    public Integer deleteEvent(String s, EventDto.EventDeleteDto requestDto) {
        return delete(s, requestDto);
    }
}
