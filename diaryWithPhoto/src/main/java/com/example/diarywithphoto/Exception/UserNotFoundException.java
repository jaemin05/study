package com.example.diarywithphoto.Exception;

import com.example.diarywithphoto.error.ErrorCode;
import com.example.diarywithphoto.error.Exception.BusinessException;

public class UserNotFoundException extends BusinessException {
    public static BusinessException Exception =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
