package com.dchans.api.admin.service.ad.impl;

import com.dchans.api.admin.dao.ad.AdDao;
import com.dchans.api.admin.dto.ad.AdDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.service.ad.AdService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    @Resource(name = "AdDao")
    private AdDao salesDao;

    private static final String NAMESPACE = "com.ad.";

    @Override
    public PageResponse<AdDto.AdResponseDto> selectAdRequestList(AdDto.AdRequestDto requestDto) {
        List<AdDto.AdResponseDto> response = salesDao.selectAdRequestList(NAMESPACE + "selectAdRequestList", requestDto);

        long totalCount = salesDao.selectAdRequestCount(NAMESPACE + "selectAdRequestCount", requestDto);

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
    public AdDto.AdResponseDto selectAdRequestDetail(AdDto.AdRequestDto requestDto) {
        return salesDao.selectAdRequestDetail(NAMESPACE + "selectAdRequestDetail", requestDto);
    }

    @Override
    public Integer updateAdRequest(AdDto.AdUpdateDto requestDto) {
        return salesDao.updateAdRequest(NAMESPACE + "updateAdRequest", requestDto);
    }


    @Override
    public PageResponse<AdDto.AdResponseDto> selectAdRegistList(AdDto.AdRequestDto requestDto) {
        List<AdDto.AdResponseDto> response = salesDao.selectAdRegistList(NAMESPACE + "selectAdRegistList", requestDto);

        long totalCount = salesDao.selectAdRegistCount(NAMESPACE + "selectAdRegistCount", requestDto);

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
    public AdDto.AdResponseDto selectAdRegistDetail(AdDto.AdRequestDto requestDto) {
        return salesDao.selectAdRegistDetail(NAMESPACE + "selectAdRegistDetail", requestDto);
    }

    @Override
    public Integer updateAdRegist(AdDto.AdUpdateDto requestDto) {
        return salesDao.updateAdRegist(NAMESPACE + "updateAdRegist", requestDto);
    }

    @Override
    public Integer deleteAdRegist(AdDto.AdDeleteDto requestDto) {
        return salesDao.deleteAdRegist(NAMESPACE + "deleteAdRegist", requestDto);
    }

}
