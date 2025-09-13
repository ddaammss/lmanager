package com.dchans.api.admin.service.event.impl;

import com.dchans.api.admin.dao.event.EventDao;
import com.dchans.api.admin.dto.event.EventDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.store.StoreDto;
import com.dchans.api.admin.service.event.EventService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Resource(name = "EventDao")
    private EventDao eventDao;

    private static final String NAMESPACE = "com.event.";

    @Override
    public PageResponse<EventDto.EventResponseDto> selectEventList(EventDto.EventRequestDto requestDto) {
        List<EventDto.EventResponseDto> response = eventDao.selectEventList(NAMESPACE + "selectEventList", requestDto);

        long totalCount = eventDao.selectEventCount(NAMESPACE + "selectEventCount", requestDto);

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
    public EventDto.EventResponseDto selectEventDetail(EventDto.EventRequestDto requestDto) {
        EventDto.EventResponseDto detail = eventDao.selectEventDetail(NAMESPACE + "selectEventDetail", requestDto);
        List<String> storeImageList = eventDao.selectEventImageList(NAMESPACE + "selectEventImageList", requestDto);
        detail.setImages(storeImageList);
        return detail;
    }

    @Override
    public Integer insertEvent(EventDto.EventCreateDto requestDto) {
        eventDao.insertEvent(NAMESPACE + "insertEvent", requestDto);
        System.out.println(requestDto.getSeq());
        return Integer.parseInt(requestDto.getSeq());
    }

    @Override
    public Integer updateEvent(EventDto.EventUpdateDto requestDto) {
        return eventDao.updateEvent(NAMESPACE + "updateEvent", requestDto);
    }

    @Override
    public Integer deleteEvent(EventDto.EventDeleteDto requestDto) {
        return eventDao.deleteEvent(NAMESPACE + "deleteEvent", requestDto);
    }


}
