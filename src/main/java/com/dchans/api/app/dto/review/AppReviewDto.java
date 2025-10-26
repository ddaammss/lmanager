package com.dchans.api.app.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppReviewDto {
    private Integer id;
    private String userNickname;
    private String content;
    private String grade;
    private String createdAt;
    private String reply;
    private String replyCreatedAt;
    private String imagePath;

}
