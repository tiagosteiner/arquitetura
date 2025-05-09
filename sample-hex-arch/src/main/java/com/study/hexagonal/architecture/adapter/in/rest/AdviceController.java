package com.study.hexagonal.architecture.adapter.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import com.study.hexagonal.architecture.application.port.in.usecase.AdviceUseCases;
import com.study.hexagonal.architecture.shared.dto.AdviceRequest;
import com.study.hexagonal.architecture.shared.dto.AdviceResponse;

@Tag(name = "Conselhos", description = "Serviço que gerencia informações de conselhos gratuitos.")
@RequestMapping(value = "/api/v1/free-advice")
@RestController
public class AdviceController {

    private final AdviceUseCases adviceUseCases;

    protected static final String OUT_OF_RANGE_MESSAGE =
            "Valid values for adviceId must be between 1 and 224.";

    public AdviceController(AdviceUseCases adviceUseCases) {
        this.adviceUseCases = adviceUseCases;
    }

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
    public ResponseEntity<AdviceResponse> importAdvice(@RequestBody @Valid AdviceRequest request) {
        if (adviceUseCases.validateRangeInterval(request.getAdviceId())) {
            return ResponseEntity.status(201).body(adviceUseCases.importAdvice(request.getAdviceId()));
        } else {
            return ResponseEntity.status(400).body(new AdviceResponse(null, OUT_OF_RANGE_MESSAGE));
        }
    }
}
