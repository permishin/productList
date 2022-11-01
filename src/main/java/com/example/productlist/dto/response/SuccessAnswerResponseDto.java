package com.example.productlist.dto.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SuccessAnswerResponseDto {

    private String message;
    private String status;

}
