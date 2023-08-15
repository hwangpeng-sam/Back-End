package com.example.plugissue.station.controller.dto;

import com.example.plugissue.station.entity.Station;
import com.example.plugissue.status.entity.Status;

public class EntityToDtoMapper {

    public static StationStatusDto mapToDto(Station station, Status status){
        StationDto stationDto = new StationDto(station);
        StatusDto statusDto = new StatusDto(status);

        return new StationStatusDto(stationDto,statusDto);
    }
}
