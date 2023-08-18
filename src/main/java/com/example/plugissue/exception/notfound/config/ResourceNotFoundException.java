package com.example.plugissue.exception.notfound.config;

import com.example.plugissue.exception.base.BaseErrorCode;
import com.example.plugissue.exception.base.BaseException;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(BaseErrorCode errorCode){
        super(errorCode);
    }
}
