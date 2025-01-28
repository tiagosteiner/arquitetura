package com.study.hexagonal.architecture.application.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record AdviceRequest (
        @NotNull(message = "O identificador do conselho precisa ser informado.")
        @Valid Integer adviceId) {}
