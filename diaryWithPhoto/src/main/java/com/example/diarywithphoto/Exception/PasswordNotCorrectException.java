package com.example.diarywithphoto.Exception;

import com.example.diarywithphoto.error.ErrorCode;
import com.example.diarywithphoto.error.Exception.BusinessException;

public class PasswordNotCorrectException extends BusinessException {
    public static BusinessException Exception =
            new PasswordNotCorrectException();

    private PasswordNotCorrectException() {
        super(ErrorCode.PASSWORD_NOT_CORRECT);
    }
}
