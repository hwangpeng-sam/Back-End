package com.example.plugissue.station.controller.dto;

import com.example.plugissue.station.entity.Station;
import com.example.plugissue.status.entity.Status;
import lombok.Getter;

@Getter
public class StationStatusDistDto {

    private Station station;
    private Status status;
    private double distance;

    public StationStatusDistDto(){

    }
    public StationStatusDistDto(Station station, Status status, double distance){
        this.station = station;
        this.status = status;
        this.distance = distance;
    }
}
