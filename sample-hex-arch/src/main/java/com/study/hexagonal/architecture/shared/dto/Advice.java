package com.study.hexagonal.architecture.shared.dto;

import lombok.Data;

@Data
public class Advice {
    private AdviceSlip slip;
    private AdviceErrorMessage message;
}
