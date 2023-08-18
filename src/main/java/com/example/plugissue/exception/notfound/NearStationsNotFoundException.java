package com.example.plugissue.exception.notfound;

import com.example.plugissue.exception.notfound.config.ResourceNotFoundErrorCode;
import com.example.plugissue.exception.notfound.config.ResourceNotFoundException;

public class NearStationsNotFoundException extends ResourceNotFoundException {

    public NearStationsNotFoundException(){
        super(ResourceNotFoundErrorCode.NEAR_STATIONS_NOT_FOUND);
    }
}
