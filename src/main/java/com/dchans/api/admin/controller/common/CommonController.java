package com.dchans.api.admin.controller.common;

import com.dchans.api.admin.dto.common.ImageDto;
import com.dchans.api.admin.service.common.CommonService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin/api/common")
public class CommonController {

    private final CommonService commonService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }

    @PostMapping("/upload/images")
    public ResponseEntity<?> uploadImages(@RequestParam(value="images",  required = false) List<MultipartFile> images,
                                          @RequestParam(value="dbImages",  required = false) List<String> dbImages,
                                          String type,
                                          String parentSeq
                                          ) {
        try {
            List<String> imageList = commonService.imageProcessing(images, dbImages, type, parentSeq);
            return ResponseEntity.ok(Map.of("imagePaths", imageList));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("이미지 업로드 실패");
        }
    }



}