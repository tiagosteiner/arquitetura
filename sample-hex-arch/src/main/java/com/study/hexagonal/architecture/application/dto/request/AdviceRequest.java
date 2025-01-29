package com.study.hexagonal.architecture.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdviceRequest {

    @NotNull(message = "O identificador do conselho precisa ser informado.")
    private Integer adviceId;
}
