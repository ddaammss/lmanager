package com.dchans.api.app.service.store.impl;

import com.dchans.api.app.dao.store.AppStoreDao;
import com.dchans.api.app.service.store.AppStoreService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AppStoreServiceImpl implements AppStoreService {
    @Resource(name = "AppStoreDao")
    private AppStoreDao storeDao;

    //private static final String NAMESPACE = "com.store.";
}
