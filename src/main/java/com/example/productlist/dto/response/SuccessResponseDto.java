package com.example.productlist.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class SuccessResponseDto {

    private String message;
    private String status;
    private LocalDateTime timestamp;


}
