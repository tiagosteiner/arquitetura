package com.study.hexagonal.architecture.shared.exception;

public class AdviceNotFoundException extends RuntimeException {
    public AdviceNotFoundException(String message) {
        super(message);
    }
}
