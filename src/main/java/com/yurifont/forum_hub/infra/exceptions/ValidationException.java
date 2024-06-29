package com.yurifont.forum_hub.infra.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException(String msg) {
        super(msg);
    }

}
