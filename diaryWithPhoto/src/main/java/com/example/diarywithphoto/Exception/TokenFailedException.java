package com.example.diarywithphoto.Exception;

import com.example.diarywithphoto.error.ErrorCode;
import com.example.diarywithphoto.error.Exception.BusinessException;

public class TokenFailedException extends BusinessException {
    public static BusinessException Exception =
            new TokenFailedException();

    private TokenFailedException() {
        super(ErrorCode.TOKEN_FAILED);
    }
}
