package com.dchans.api.admin.controller.store;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.admin.dto.common.PageApiResponseDto;
import com.dchans.api.admin.dto.common.PageResponse;
import com.dchans.api.admin.dto.settings.coupon.CouponDto;
import com.dchans.api.admin.dto.store.StoreDto;
import com.dchans.api.admin.service.settings.coupon.CouponService;
import com.dchans.api.admin.service.store.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin/api/store")
public class StoreController {

    private final StoreService storeService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/list")
    public ResponseEntity<PageApiResponseDto<StoreDto.StoreResponseDto>> selectStoreList(@RequestBody StoreDto.StoreRequestDto requestDto) {
        PageResponse<StoreDto.StoreResponseDto> responseDto = storeService.selectStoreList(requestDto);
        return ResponseEntity.ok(PageApiResponseDto.success(responseDto));
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponseDto<StoreDto.StoreResponseDto>> selectStoreDetail(@RequestBody StoreDto.StoreRequestDto requestDto) {
        StoreDto.StoreResponseDto responseDto = storeService.selectStoreDetail(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseDto));
    }

    @PostMapping("/upsert")
    public ResponseEntity<ApiResponseDto<Integer>> upsertStore(@RequestBody StoreDto.StoreCreateDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(storeService.upsertStore(requestDto)));
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponseDto<Integer>> deleteStore(@RequestBody StoreDto.StoreDeleteDto requestDto) {
        return ResponseEntity.ok(ApiResponseDto.success(storeService.deleteStore(requestDto)));
    }

    @PostMapping("/upload/images")
    public ResponseEntity<?> uploadImages(@RequestParam(value="images",  required = false) List<MultipartFile> images) {
        try {
            List<String> imagePaths = new ArrayList<>();

            for (MultipartFile image : images) {
                String savedPath = saveImageFile(image);
                imagePaths.add(savedPath);
            }

            return ResponseEntity.ok(Map.of("imagePaths", imagePaths));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("이미지 업로드 실패");
        }
    }

    private String saveImageFile(MultipartFile file) throws IOException {
        String uploadDir = "uploads/store/";
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(file.getInputStream(), uploadPath.resolve(fileName));
        return "/uploads/store/" + fileName; // DB에 저장할 경로
    }

}