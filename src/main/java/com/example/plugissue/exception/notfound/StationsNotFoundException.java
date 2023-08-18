package com.example.plugissue.exception.notfound;

import com.example.plugissue.exception.notfound.config.ResourceNotFoundErrorCode;
import com.example.plugissue.exception.notfound.config.ResourceNotFoundException;

public class StationsNotFoundException extends ResourceNotFoundException {

    public StationsNotFoundException(){
        super(ResourceNotFoundErrorCode.STATIONS_NOT_FOUND);
    }
}
