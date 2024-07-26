package com.app.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

@NoArgsConstructor
@StandardException(access = AccessLevel.PUBLIC)
public class TodoException extends RuntimeException {
}