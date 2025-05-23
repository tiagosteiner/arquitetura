package com.study.hexagonal.architecture.adapter.out.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import com.study.hexagonal.architecture.shared.classes.BaseEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_advice")
public class JpaAdvice extends BaseEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "advice_text")
    private String adviceText;
}
