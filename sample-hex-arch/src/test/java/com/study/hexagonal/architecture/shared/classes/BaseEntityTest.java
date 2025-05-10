package com.study.hexagonal.architecture.shared.classes;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BaseEntityTest {

    @Test
    void shouldPrePersistAnEntityWithSuccess() {
        var entity = new BaseEntity();
        assertNull(entity.getCreatedAt());
        assertNull(entity.getUpdatedAt());

        entity.prePersist();

        assertNotNull(entity.getCreatedAt());
        assertNotNull(entity.getUpdatedAt());
    }

    @Test
    void shouldPreUpdateAnEntityWithSuccess() {
        var entity = new BaseEntity();
        assertNull(entity.getCreatedAt());
        assertNull(entity.getUpdatedAt());

        entity.preUpdate();

        assertNull(entity.getCreatedAt());
        assertNotNull(entity.getUpdatedAt());
    }
}
