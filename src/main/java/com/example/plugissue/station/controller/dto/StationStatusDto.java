package com.example.plugissue.station.controller.dto;

import com.example.plugissue.station.entity.Station;
import com.example.plugissue.status.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class StationStatusDto {

    private Station station;
    private Status status;

    public StationStatusDto(){

    }
    public StationStatusDto(Station station, Status status){
        this.station = station;
        this.status = status;
    }
}
