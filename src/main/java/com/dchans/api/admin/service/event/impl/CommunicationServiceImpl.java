package com.dchans.api.admin.service.event.impl;

import com.dchans.api.admin.dao.event.CommunicationDao;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.event.CommunicationDto;
import com.dchans.api.admin.service.event.CommunicationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationServiceImpl implements CommunicationService {
    @Resource(name = "CommunicationDao")
    private CommunicationDao communicationDao ;

    private static final String NAMESPACE = "com.communication.";

    @Override
    public PageResponse<CommunicationDto.CommunicationResponseDto> selectCommunicationList(CommunicationDto.CommunicationRequestDto requestDto) {
        List<CommunicationDto.CommunicationResponseDto> response = communicationDao.selectCommunicationList(NAMESPACE + "selectCommunicationList", requestDto);

        long totalCount = communicationDao.selectCommunicationCount(NAMESPACE + "selectCommunicationCount", requestDto);

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
    public CommunicationDto.CommunicationResponseDto selectCommunicationDetail(CommunicationDto.CommunicationRequestDto requestDto) {
        return communicationDao.selectCommunicationDetail(NAMESPACE + "selectCommunicationDetail", requestDto);
    }

    @Override
    public Integer updateCommunication(CommunicationDto.CommunicationUpdateDto requestDto) {
        return communicationDao.updateCommunication(NAMESPACE + "updateCommunication", requestDto);
    }
}
