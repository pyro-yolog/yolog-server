package com.pyro.yolog.global.s3.api;

import com.pyro.yolog.global.s3.dto.response.S3ImageResponse;
import com.pyro.yolog.global.s3.service.S3ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("images")
public class S3ImageImageController implements S3ImageApi {
    private final S3ImageService s3ImageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    @Override
    public S3ImageResponse uploadImage(@RequestPart(value = "image", required = false) MultipartFile image) {
        return s3ImageService.uploadImage(image);
    }

    
}
