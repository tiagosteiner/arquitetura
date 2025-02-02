package com.study.hexagonal.architecture.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.springframework.http.ResponseEntity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.hexagonal.architecture.application.service.AdviceService;
import com.study.hexagonal.architecture.mock.AdviceRequestMock;
import com.study.hexagonal.architecture.mock.AdviceResponseMock;

@ExtendWith(MockitoExtension.class)
class AdviceControllerAdapterTest {
    @Mock private AdviceService adviceService;
    @InjectMocks private AdviceControllerAdapter adviceControllerAdapter;

    @Test
    @DisplayName("should call the advice import service successfully")
    void shouldCallTheAdviceImportServiceSuccessfully() {
        var adviceRequest = AdviceRequestMock.createValidAdviceRequest();
        var adviceResponse = AdviceResponseMock.createAdviceResponseSuccess();
        var expected = ResponseEntity.status(201).body(adviceResponse);
        when(adviceService.importAdvice(1)).thenReturn(expected);

        var actual = adviceControllerAdapter.importAdvice(adviceRequest);

        assertEquals(expected, actual);
    }
}
