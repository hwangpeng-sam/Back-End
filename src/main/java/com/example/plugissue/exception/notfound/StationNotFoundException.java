package com.example.plugissue.exception.notfound;

import com.example.plugissue.exception.notfound.config.ResourceNotFoundErrorCode;
import com.example.plugissue.exception.notfound.config.ResourceNotFoundException;

public class StationNotFoundException extends ResourceNotFoundException {

    public StationNotFoundException(){
        super(ResourceNotFoundErrorCode.STATION_NOT_FOUND);
    }
}
