package com.dchans.api.app.service.product;

import com.dchans.api.app.dto.product.AppProductDto;

import java.util.List;

public interface AppProductService {
    List<AppProductDto> selectProductList();
}
