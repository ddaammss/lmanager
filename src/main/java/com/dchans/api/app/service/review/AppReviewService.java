package com.dchans.api.app.service.review;

import com.dchans.api.app.dto.review.AppReviewDto;

import java.util.List;

public interface AppReviewService {
    List<AppReviewDto> selectReviewList();
}
