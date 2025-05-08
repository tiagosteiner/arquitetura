package com.study.hexagonal.architecture.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.hexagonal.architecture.application.port.out.rest.AdviceApi;
import com.study.hexagonal.architecture.domain.service.AdviceDomainService;
import com.study.hexagonal.architecture.mock.AdviceDtoMock;

@ExtendWith(MockitoExtension.class)
class AdviceServiceImplTest {

    @Mock private AdviceApi adviceApi;
    @Mock private AdviceDomainService adviceDomainService;

    @InjectMocks private AdviceServiceImpl adviceServiceImpl;

    @BeforeEach
    void setup() {
        adviceServiceImpl = new AdviceServiceImpl(adviceApi, adviceDomainService);
    }

    @Test
    void shouldValidateRangeIntervalInside() {
        var expected = adviceServiceImpl.validateRangeInterval(1);
        assertTrue(expected);
    }

    @Test
    void shouldValidateRangeIntervalLessThan() {
        var expected = adviceServiceImpl.validateRangeInterval(-1);
        assertFalse(expected);
    }

    @Test
    void shouldValidateRangeIntervalGreaterThan() {
        var expected = adviceServiceImpl.validateRangeInterval(300);
        assertFalse(expected);
    }

    @Test
    void shouldImportAdviceWithSuccess() {
        var adviceDtoMock = AdviceDtoMock.createValidAdviceDto();
        when(adviceApi.getAdviceById(1)).thenReturn(adviceDtoMock);
        doNothing().when(adviceDomainService).persistAdvice(adviceDtoMock);

        var expected = adviceServiceImpl.importAdvice(1);
        assertEquals(
                "Remember that spiders are more afraid of you, than you are of them.",
                expected.getAdvice());
    }
}
