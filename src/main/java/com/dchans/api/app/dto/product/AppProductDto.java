package com.dchans.api.app.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppProductDto {
    private Integer id;
    private String name;
    private String price;
    private String description;
    private String imagePath;
}
