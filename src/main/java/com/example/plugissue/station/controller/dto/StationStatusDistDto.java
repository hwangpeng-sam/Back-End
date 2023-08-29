package com.example.plugissue.station.controller.dto;

import com.example.plugissue.station.entity.Station;
import com.example.plugissue.status.entity.Status;
import lombok.Getter;

@Getter
public class StationStatusDistDto {

    private Station station;
    private Integer Occupancy0;
    private Double Occupancy20_0;
    private Double Occupancy40_0;
    private Double Occupancy60_0;
    private Double Occupancy120_0;
    private double distance;

    public StationStatusDistDto(){

    }
    public StationStatusDistDto(Station station, Status status, double distance){
        this.station = station;
        this.Occupancy0 = status.getOccupancy0();
        this.Occupancy20_0 = status.getOccupancy20_0();
        this.Occupancy40_0 = status.getOccupancy40_0();
        this.Occupancy60_0 = status.getOccupancy60_0();
        this.Occupancy120_0 = status.getOccupancy120_0();
        this.distance = distance;
    }
}
