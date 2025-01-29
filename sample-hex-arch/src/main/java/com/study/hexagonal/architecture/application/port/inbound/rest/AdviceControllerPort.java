package com.study.hexagonal.architecture.application.port.inbound.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.study.hexagonal.architecture.application.dto.request.AdviceRequest;

@Tag(name = "Conselhos", description = "Serviço que gerencia informações de conselhos gratuitos.")
@RequestMapping(value = "/api/v1/free-advice")
public interface AdviceControllerPort {

    @Operation(
            summary = "Importar conselhos grátis",
            description = "Importar conselho grátis pelo seu identificador.")
    @PostMapping("/import")
    ResponseEntity<Object> importAdvice(@RequestBody AdviceRequest request);
}
