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
        BannerDto.BannerResponseDto mainbanner2 = bannerDao.selectMainBanner2(NAMESPACE + "selectMainBanner2", requestDto);
        banner.setMainSeq2(mainbanner2.getMainSeq2());
        banner.setMainName2(mainbanner2.getMainName2());
        banner.setMainContent2(mainbanner2.getMainContent2());

        List<String> mainImageList = bannerDao.selectMainBannerImageList(NAMESPACE + "selectMainBannerImageList", requestDto);
        banner.setMainImages(mainImageList);
        List<String> mainImageList2 = bannerDao.selectMainBanner2ImageList(NAMESPACE + "selectMainBanner2ImageList", requestDto);
        banner.setMainImages2(mainImageList2);

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
