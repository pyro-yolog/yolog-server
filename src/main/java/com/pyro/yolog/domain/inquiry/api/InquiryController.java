package com.pyro.yolog.domain.inquiry.api;

import com.pyro.yolog.domain.inquiry.dto.request.InquiryAnswerRequest;
import com.pyro.yolog.domain.inquiry.dto.request.InquiryRequest;
import com.pyro.yolog.domain.inquiry.dto.response.DetailInquiryResponse;
import com.pyro.yolog.domain.inquiry.dto.response.InquiryPreview;
import com.pyro.yolog.domain.inquiry.service.InquiryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("inquiries")
public class InquiryController implements InquiryApi {
    private final InquiryService inquiryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    @Override
    public void createInquiry(@Valid @RequestBody InquiryRequest request) {
        inquiryService.createInquiry(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    @Override
    public List<InquiryPreview> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    @Override
    public DetailInquiryResponse getDetailInquiry(@PathVariable Long id) {
        return inquiryService.getDetailInquiry(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    @Override
    public void updateAnswer(@PathVariable Long id, @Valid @RequestBody InquiryAnswerRequest request) {
        inquiryService.updateAnswer(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Override
    public void deleteAnswer(@PathVariable Long id) {
        inquiryService.deleteInquiry(id);
    }
}
