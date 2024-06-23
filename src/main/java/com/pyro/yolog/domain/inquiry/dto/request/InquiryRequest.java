package com.pyro.yolog.domain.inquiry.dto.request;

import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquiryRequest {
    @NotBlank
    private String content;

    private List<String> imageUrls;

}
