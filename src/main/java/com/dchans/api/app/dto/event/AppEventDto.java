package com.dchans.api.app.dto.event;

import com.dchans.api.app.dto.image.AppImageDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppEventDto {
    private String seq;
    private String eventName;
    private String eventDate;
    private String content;
    private String endDate;
    private String createdAt;
    private String status;
    private String imagePath;
    private List<AppEventDto> eventListDto;
    private List<AppImageDto> imageListDto;
}

