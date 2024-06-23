package com.pyro.yolog.domain.inquiry.api;

import com.pyro.yolog.domain.inquiry.dto.request.InquiryRequest;
import com.pyro.yolog.domain.inquiry.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("inquiries")
public class InquiryController implements InquiryApi {
    private final InquiryService inquiryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    @Override
    public void createInquiry(@RequestBody InquiryRequest request) {
        inquiryService.createInquiry(request);
    }
}
