package com.dchans.api.admin.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ImageDto {
    private String parentSeq;
    private String type;
    private List<String> imagePath;
}
