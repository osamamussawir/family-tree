package com.familytree.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberNotFoundException extends RuntimeException {
    private String message;
}
