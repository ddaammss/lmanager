package com.dchans.api.admin.service.member.impl;

import com.dchans.api.admin.dao.member.PointDao;
import com.dchans.api.admin.dto.member.PointDto;
import com.dchans.api.admin.service.member.PointService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PointServiceImpl implements PointService {
    @Resource(name = "PointDao")
    private PointDao pointDao ;

    private static final String NAMESPACE = "com.point.";

    @Override
    public PointDto.PointResponseDto selectPointSetting() {
        return pointDao.selectPointSetting(NAMESPACE + "selectPointSetting");
    }

    @Override
    public Integer updatePoint(PointDto.PointUpdateDto requestDto) {
        return pointDao.updatePoint(NAMESPACE + "updatePoint", requestDto);
    }

}
