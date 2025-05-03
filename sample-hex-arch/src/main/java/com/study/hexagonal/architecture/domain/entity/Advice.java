package com.study.hexagonal.architecture.domain.entity;

public class Advice {

    public Advice() {}

    public Advice(Integer id, String adviceText) {
        this.id = id;
        this.adviceText = adviceText;
    }

    private Integer id;

    private String adviceText;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getAdviceText() {
        return adviceText;
    }

    public void setAdviceText(final String adviceText) {
        this.adviceText = adviceText;
    }
}
