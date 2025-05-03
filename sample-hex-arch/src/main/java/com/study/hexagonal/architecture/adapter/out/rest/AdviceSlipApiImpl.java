package com.study.hexagonal.architecture.adapter.out.rest;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import com.study.hexagonal.architecture.application.port.out.rest.AdviceApi;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;
import com.study.hexagonal.architecture.shared.exception.AdviceNotFoundException;

@Service
@RequiredArgsConstructor
public class AdviceSlipApiImpl implements AdviceApi {

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
