package com.dchans.api.admin.service.common;

import com.dchans.api.admin.dto.common.ImageDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.store.StoreDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CommonService {
    List<String> imageProcessing(List<MultipartFile> images, List<String> dbImages, String type, String parentSeq) throws IOException;
}
