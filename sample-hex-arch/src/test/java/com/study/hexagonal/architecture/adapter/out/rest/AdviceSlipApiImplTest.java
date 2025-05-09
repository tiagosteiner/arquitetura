package com.study.hexagonal.architecture.adapter.out.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.hexagonal.architecture.mock.AdviceDtoMock;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;
import com.study.hexagonal.architecture.shared.exception.AdviceNotFoundException;

@ExtendWith(MockitoExtension.class)
class AdviceSlipApiImplTest {

    @Mock private AdviceSlipClient adviceSlipClient;
    @Mock private ObjectMapper objectMapper;

    @InjectMocks private AdviceSlipApiImpl adviceSlipApiImpl;

    @Test
    void shouldGetAdviceByIdWithSuccess() throws JsonProcessingException {
        var adviceDto = AdviceDtoMock.createValidAdviceDto();
        when(adviceSlipClient.getAdviceById(1)).thenReturn("json here");
        when(objectMapper.readValue("json here", AdviceDto.class)).thenReturn(adviceDto);

        var actual = adviceSlipApiImpl.getAdviceById(1);

        assertEquals(1, actual.getSlip().getId());
        assertEquals(
                "Remember that spiders are more afraid of you, than you are of them.",
                actual.getSlip().getAdvice());
    }

    @Test
    void shouldGetAdviceByIdThrowException() throws JsonProcessingException {
        when(adviceSlipClient.getAdviceById(1)).thenReturn("exception here");
        when(objectMapper.readValue("exception here", AdviceDto.class))
                .thenThrow(JsonProcessingException.class);

        RuntimeException exception =
                assertThrows(
                        AdviceNotFoundException.class,
                        () -> {
                            adviceSlipApiImpl.getAdviceById(1);
                        });

        assertEquals("exception here", exception.getMessage());
    }
}
