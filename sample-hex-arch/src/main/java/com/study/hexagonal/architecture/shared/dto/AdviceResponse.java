package com.study.hexagonal.architecture.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdviceResponse {
    private String advice;
    private String error;
}
