package com.example.plugissue.station.controller.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FinalDto {

    private int status;

    private String message;
    private List data;

    public FinalDto(int status, String message, List data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
