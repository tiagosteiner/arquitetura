package com.study.hexagonal.architecture.shared.dto;

import lombok.Data;

@Data
public class AdviceDto {
    private AdviceSlipDto slip;
    private AdviceErrorMessageDto message;
}
