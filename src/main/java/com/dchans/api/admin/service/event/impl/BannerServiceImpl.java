package com.dchans.api.admin.service.event.impl;

import com.dchans.api.admin.dao.event.BannerDao;
import com.dchans.api.admin.dto.event.BannerDto;
import com.dchans.api.admin.service.event.BannerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Resource(name = "BannerDao")
    private BannerDao bannerDao;

    private static final String NAMESPACE = "com.banner.";

    @Override
    public BannerDto.BannerResponseDto selectMainBanner(BannerDto.BannerRequestDto requestDto) {
        BannerDto.BannerResponseDto main = bannerDao.selectMainBanner(NAMESPACE + "selectMainBanner", requestDto);
        List<String> imageList = bannerDao.selectMainBannerImageList(NAMESPACE + "selectMainBannerImageList", requestDto);
        main.setImages(imageList);
        return main;
    }

    @Override
    public BannerDto.BannerResponseDto selectSubBanner(BannerDto.BannerRequestDto requestDto) {
        BannerDto.BannerResponseDto main = bannerDao.selectSubBanner(NAMESPACE + "selectSubBanner", requestDto);
        List<String> imageList = bannerDao.selectSubBannerImageList(NAMESPACE + "selectSubBannerImageList", requestDto);
        main.setImages(imageList);
        return main;
    }

    @Override
    public Integer insertBanner(BannerDto.BannerCreateDto requestDto) {
        bannerDao.insertBanner(NAMESPACE + "insertBanner", requestDto);
        return Integer.parseInt(requestDto.getSeq());
    }

    @Override
    public Integer updateBanner(BannerDto.BannerUpdateDto requestDto) {
        return bannerDao.updateBanner(NAMESPACE + "updateBanner", requestDto);
    }
}
