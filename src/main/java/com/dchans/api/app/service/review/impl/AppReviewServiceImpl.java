package com.dchans.api.app.service.review.impl;

import com.dchans.api.app.dto.review.AppReviewDto;
import com.dchans.api.app.service.review.AppReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppReviewServiceImpl implements AppReviewService {
    @Override
    public List<AppReviewDto> selectReviewList() {
        return List.of();
    }
}
