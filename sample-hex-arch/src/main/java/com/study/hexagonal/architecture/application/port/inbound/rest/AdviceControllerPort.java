package com.study.hexagonal.architecture.application.port.inbound.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.study.hexagonal.architecture.application.dto.request.AdviceRequest;
import com.study.hexagonal.architecture.application.dto.response.AdviceResponse;

@Tag(name = "Conselhos", description = "Serviço que gerencia informações de conselhos gratuitos.")
@RequestMapping(value = "/api/v1/free-advice")
public interface AdviceControllerPort {

    @Operation(
            summary = "Importar conselhos grátis",
            description =
                    "Importar conselho grátis pelo seu identificador. Os valores válidos para identicador devem estar entre 1 e 224.")
    @ApiResponses(
            value = {
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        responseCode = "201",
                        description = "Retorna o conselho grátis pelo seu identificador."),
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        responseCode = "400",
                        description = "Os valores válidos para identicador devem estar entre 1 e 224."),
            })
    @PostMapping("/import")
    ResponseEntity<AdviceResponse> importAdvice(@RequestBody AdviceRequest request);
}
