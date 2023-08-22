package com.example.plugissue.station.controller.dto;

import com.example.plugissue.status.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatusDto {

    private Long id;

    private Integer occupancy_20;

    private Integer occupancy_40;

    private Integer occupancy_60;

    private Integer occupancy_120;

    public StatusDto(Status status){
        this.id = status.getId();
        this.occupancy_20 = status.getOccupancy_20();
        this.occupancy_40 = status.getOccupancy_40();
        this.occupancy_60 = status.getOccupancy_60();
        this.occupancy_120 = status.getOccupancy_120();
    }
}
