package com.study.hexagonal.architecture.adapter.in.rest;

import static com.study.hexagonal.architecture.adapter.in.rest.AdviceController.OUT_OF_RANGE_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.springframework.http.HttpStatusCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.hexagonal.architecture.application.port.in.usecase.AdviceUseCases;
import com.study.hexagonal.architecture.mock.AdviceRequestMock;
import com.study.hexagonal.architecture.mock.AdviceResponseMock;

@ExtendWith(MockitoExtension.class)
class AdviceControllerTest {

    @Mock private AdviceUseCases adviceUseCases;

    @InjectMocks private AdviceController adviceController;

    @Test
    void shouldImportAdviceWithSuccess() {
        var adviceRequestMock = AdviceRequestMock.createValidAdviceRequest();
        var adviceResponseMockSuccess = AdviceResponseMock.createAdviceResponseSuccess();
        when(adviceUseCases.validateRangeInterval(1)).thenReturn(true);
        when(adviceUseCases.importAdvice(1)).thenReturn(adviceResponseMockSuccess);

        var expected = adviceController.importAdvice(adviceRequestMock);

        assertEquals(HttpStatusCode.valueOf(201), expected.getStatusCode());
        assertTrue(expected.hasBody());
        assertEquals(
                "Remember that spiders are more afraid of you, than you are of them.",
                expected.getBody().getAdvice());
    }

    @Test
    void shouldImportAdviceOutOfRange() {
        var adviceRequestMock = AdviceRequestMock.createValidAdviceRequest();
        when(adviceUseCases.validateRangeInterval(1)).thenReturn(false);

        var expected = adviceController.importAdvice(adviceRequestMock);

        assertEquals(HttpStatusCode.valueOf(400), expected.getStatusCode());
        assertTrue(expected.hasBody());
        assertEquals(OUT_OF_RANGE_MESSAGE, expected.getBody().getError());
    }
}
