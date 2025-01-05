package com.wgdesign.shared.domain.exception;

public record ErrorDetails(
        String message,
        String details,
        String errorCode
) { }
