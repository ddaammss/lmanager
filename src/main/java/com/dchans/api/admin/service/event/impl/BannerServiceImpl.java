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
        BannerDto.BannerResponseDto banner = bannerDao.selectMainBanner(NAMESPACE + "selectMainBanner", requestDto);
        List<String> mainImageList = bannerDao.selectMainBannerImageList(NAMESPACE + "selectMainBannerImageList", requestDto);
        banner.setMainImages(mainImageList);

        BannerDto.BannerResponseDto sub = bannerDao.selectSubBanner(NAMESPACE + "selectSubBanner", requestDto);
        banner.setSubSeq(sub.getSubSeq());
        banner.setSubName(sub.getSubName());
        banner.setSubContent(sub.getSubContent());
        List<String> subImageList = bannerDao.selectSubBannerImageList(NAMESPACE + "selectSubBannerImageList", requestDto);
        banner.setSubImages(subImageList);
        return banner;
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
