package com.study.hexagonal.architecture.adapter.outbound.rest;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import com.study.hexagonal.architecture.application.port.outbound.rest.AdviceApiPort;
import com.study.hexagonal.architecture.infrastructure.gateway.adviceslip.AdviceSlipClient;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;
import com.study.hexagonal.architecture.shared.exception.AdviceNotFoundException;

@Service
@RequiredArgsConstructor
public class AdviceSlipApiAdapter implements AdviceApiPort {

    private final AdviceSlipClient adviceSlipClient;
    private final ObjectMapper objectMapper;

    @Override
    public AdviceDto getAdviceById(Integer id) {
        var adviceAsString = adviceSlipClient.getAdviceById(id);
        return deserializeMessage(adviceAsString);
    }

    private AdviceDto deserializeMessage(String adviceStr) {
        try {
            return objectMapper.readValue(adviceStr, AdviceDto.class);
        } catch (JsonProcessingException e) {
            throw new AdviceNotFoundException(adviceStr);
        }
    }
}
