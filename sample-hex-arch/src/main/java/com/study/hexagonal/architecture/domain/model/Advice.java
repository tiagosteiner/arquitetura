package com.study.hexagonal.architecture.domain.model;

import com.study.hexagonal.architecture.shared.classes.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_advice")
public class Advice extends BaseEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "advice_text")
    private String adviceText;
}
