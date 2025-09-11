package com.dchans.api.admin.service.common.impl;

import com.dchans.api.admin.dao.common.CommonDao;
import com.dchans.api.admin.dao.store.StoreDao;
import com.dchans.api.admin.dto.common.ImageDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.store.StoreDto;
import com.dchans.api.admin.service.common.CommonService;
import com.dchans.api.admin.service.store.StoreService;
import jakarta.annotation.Resource;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {
    @Resource(name = "CommonDao")
    private CommonDao commonDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String NAMESPACE = "com.common.";

    @Override
    @Transactional
    public List<String> imageProcessing(List<MultipartFile> images, List<String> dbImages, String type, String parentSeq) throws IOException {
        ImageDto requestDto = new ImageDto();
        requestDto.setParentSeq(parentSeq);
        requestDto.setType(type);

        List<String> imagePaths = new ArrayList<>();

        if (dbImages != null) {
            imagePaths.addAll(dbImages);
        }
        if (images != null) {
            for (MultipartFile image : images) {
                String savedPath = saveImageFile(image, type);
                imagePaths.add(savedPath);
            }
        }
        requestDto.setImagePath(imagePaths);

        commonDao.deleteImage(NAMESPACE + "deleteImage", requestDto);
        commonDao.insertImage(NAMESPACE + "insertImage", requestDto);

        return requestDto.getImagePath();
    }

    private String saveImageFile(MultipartFile file, String type) throws IOException {
        String uploadDir = "uploads/" + type + "/";

        String originalFileName = file.getOriginalFilename();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = timestamp + "_" + originalFileName;

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            System.out.println("디렉토리 생성 시도: " + uploadPath.toAbsolutePath());
            try {
                Files.createDirectories(uploadPath);
                System.out.println("디렉토리 생성 성공: {}" + uploadPath.toAbsolutePath());
            } catch (IOException e) {
                System.out.println("디렉토리 생성 실패:");
                throw e;
            }

        }

        Files.copy(file.getInputStream(), uploadPath.resolve(fileName));
        return "/uploads/" + type + "/" + fileName; // DB에 저장할 경로
    }
}
