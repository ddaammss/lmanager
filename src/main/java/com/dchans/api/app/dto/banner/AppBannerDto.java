package com.dchans.api.app.dto.banner;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppBannerDto {

    private String seq;
    private String name;
    private String content;
    private String imagePath;
}
