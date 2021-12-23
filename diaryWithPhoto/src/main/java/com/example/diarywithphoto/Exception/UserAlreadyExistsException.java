package com.example.diarywithphoto.Exception;

import com.example.diarywithphoto.error.ErrorCode;
import com.example.diarywithphoto.error.Exception.BusinessException;

public class UserAlreadyExistsException extends BusinessException {
    public static BusinessException Exception =
            new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
