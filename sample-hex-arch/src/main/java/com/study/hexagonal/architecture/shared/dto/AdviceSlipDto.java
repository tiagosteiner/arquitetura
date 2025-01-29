package com.study.hexagonal.architecture.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdviceSlipDto {
    private Integer id;
    private String advice;
}
