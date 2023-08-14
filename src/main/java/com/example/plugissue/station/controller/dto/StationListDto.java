package com.example.plugissue.station.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StationListDto {

    @JsonProperty("stationList")
    private List<SimpleStationDto> simpleStationDtos;

}
