package com.example.plugissue.station.controller.dto;

import com.example.plugissue.station.entity.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SimpleStationDto {

    private Long id;

    private String sId;

    private Double lng;

    private Double lat;

    private String name;

    public SimpleStationDto(Station station){
        this.id = station.getId();
        this.sId = station.getSId();
        this.lng = station.getLongitude();
        this.lat = station.getLatitude();
        this.name = station.getName();
    }
}
