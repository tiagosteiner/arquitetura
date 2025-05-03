package com.study.hexagonal.architecture.shared.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdviceRequest {

    @NotNull(message = "O identificador do conselho precisa ser informado.")
    private Integer adviceId;
}
