package com.familytree.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberBadRequestException extends RuntimeException {
    private String message;
}
