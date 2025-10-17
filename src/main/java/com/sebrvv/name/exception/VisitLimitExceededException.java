package com.sebrvv.name.exception;

public class VisitLimitExceededException extends RuntimeException {
    public VisitLimitExceededException(String message) {
        super(message);
    }
}
