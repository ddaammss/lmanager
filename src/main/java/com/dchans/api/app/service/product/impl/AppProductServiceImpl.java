package com.dchans.api.app.service.product.impl;

import com.dchans.api.app.dao.product.AppProductDao;
import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.app.service.product.AppProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppProductServiceImpl implements AppProductService {
    @Resource(name = "AppProductDao")
    private AppProductDao appProductDao;
    private static final String NAMESPACE = "com.app.main.";

    @Override
    public List<AppProductDto> selectProductList() {
        return appProductDao.selectProductList(NAMESPACE + "selectProductList");
    }
}
