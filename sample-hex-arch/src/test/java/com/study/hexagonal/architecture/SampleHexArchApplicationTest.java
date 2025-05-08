package com.study.hexagonal.architecture;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

@SpringBootTest
class SampleHexArchApplicationTest {

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> SampleHexArchApplication.main(new String[0]));
    }
}
