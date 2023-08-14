package com.example.plugissue.station.controller.dto;

import com.example.plugissue.station.entity.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StationDto {
    private Long id;

    private Long sId;

    private Double lng;

    private Double lat;

    private String name;

    private String address;


    public StationDto (Station station){
        this.id = station.getId();
        this.sId = station.getSId();
        this.lng = station.getLongitude();
        this.lat = station.getLatitude();
        this.name = station.getName();
        this.address = station.getAddress();
    }
}
