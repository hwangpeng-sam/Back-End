package com.example.plugissue.station.controller.dto;

import com.example.plugissue.station.entity.Station;
import com.example.plugissue.status.entity.Status;
import lombok.Getter;

@Getter
public class StationStatusAvgDto {

    private Station station;
    private Status status;
    private Double charAvg20;
    private Double charAvg40;
    private Double charAvg60;
    private Double charAvg120;


    public StationStatusAvgDto(){

    }
    public StationStatusAvgDto(Station station, Status status, Double charAvg20, Double charAvg40, Double charAvg60, Double charAvg120){
        this.station = station;
        this.status = status;
        this.charAvg20 = charAvg20;
        this.charAvg40 = charAvg40;
        this.charAvg60 = charAvg60;
        this.charAvg120 = charAvg120;
    }
}
