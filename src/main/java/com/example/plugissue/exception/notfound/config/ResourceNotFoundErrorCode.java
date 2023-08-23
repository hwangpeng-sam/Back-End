package com.example.plugissue.exception.notfound.config;

import com.example.plugissue.exception.base.BaseErrorCode;

public enum ResourceNotFoundErrorCode implements BaseErrorCode {

    STATIONS_NOT_FOUND("STATIONS","해당 범위 내에 충전소가 존재하지 않습니다."),
    STATION_NOT_FOUND("STATION","주어진 id에 해당하는 충전소를 조회할 수 없습니다."),
    NEAR_STATIONS_NOT_FOUND("NEAR_STATIONS","3km 내에 충전소가 존재하지 않습니다.");


    private String code;
    private String message;

    ResourceNotFoundErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode(){
        return code;
    }

    @Override
    public String getMessage(){
        return message;
    }

}
