package com.example.diarywithphoto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PASSWORD_NOT_CORRECT(401, "Password Not Correct"),
    USER_NOT_FOUND(500, "User Not Found"),
    TOKEN_FAILED(401, "Token Failed"),
    USER_ALREADY_EXISTS(409, "User Already Exists");

    private int statues;
    private String message;
}
