package com.dchans.api.app.dto.main;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppMainDto {
    private List<AppStoreDto>  storeDto;
    private List<AppProductDto> productDto;
    private List<AppReviewDto> reviewDto;
}
