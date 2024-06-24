package com.pyro.yolog.domain.inquiry.dto;

import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateInquiryImageDto {
    private Inquiry inquiry;
    private List<String> imageUrls;
}
