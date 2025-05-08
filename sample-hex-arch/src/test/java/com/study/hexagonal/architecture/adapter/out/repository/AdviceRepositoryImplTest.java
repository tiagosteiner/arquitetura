package com.study.hexagonal.architecture.adapter.out.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.hexagonal.architecture.mock.AdviceMock;
import com.study.hexagonal.architecture.mock.JpaAdviceMock;
import com.study.hexagonal.architecture.shared.mapper.AdviceMapper;

@ExtendWith(MockitoExtension.class)
class AdviceRepositoryImplTest {

    @Mock private JpaAdviceRepository jpaAdviceRepository;
    @Mock private AdviceMapper adviceMapper;

    @InjectMocks private AdviceRepositoryImpl adviceRepositoryImpl;

    @Test
    void shouldExecuteAdvicePersistenceWithSuccess() {
        var domainEntity = AdviceMock.createValidAdviceEntity();
        var jpaEntity = JpaAdviceMock.createValidJpaAdviceEntity();
        when(adviceMapper.domainToJpa(domainEntity)).thenReturn(jpaEntity);
        when(jpaAdviceRepository.save(jpaEntity)).thenReturn(jpaEntity);
        when(adviceMapper.jpaToDomain(jpaEntity)).thenReturn(domainEntity);

        var actual = adviceRepositoryImpl.save(domainEntity);

        assertEquals(domainEntity.getAdviceText(), actual.getAdviceText());
        assertEquals(jpaEntity.getAdviceText(), actual.getAdviceText());
    }
}
