package com.example.plugissue.station.controller.dto;

import com.example.plugissue.status.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import java.util.List;

@Getter
@AllArgsConstructor
public class StatusDto {

    private Long id;

    private Integer Occupancy0; // 현재상태 라벨링 컬럼

    private Double Occupancy20_0; // 소수점

    private Double Occupancy20_1;

    private Double Occupancy20_2;

    private Double Occupancy40_0;

    private Double Occupancy40_1;

    private Double Occupancy40_2;

    private Double Occupancy60_0;

    private Double Occupancy60_1;

    private Double Occupancy60_2;

    private Double Occupancy120_0;

    private Double Occupancy120_1;

    private Double Occupancy120_2;


    public StatusDto(Status status){
        this.id = status.getId();
        this.Occupancy0 = status.getOccupancy0();
        this.Occupancy20_0 = status.getOccupancy20_0();
        this.Occupancy20_1 = status.getOccupancy20_1();
        this.Occupancy20_2 = status.getOccupancy20_2();
        this.Occupancy40_0 = status.getOccupancy40_0();
        this.Occupancy40_1 = status.getOccupancy40_1();
        this.Occupancy40_2 = status.getOccupancy40_2();
        this.Occupancy60_0 = status.getOccupancy60_0();
        this.Occupancy60_1 = status.getOccupancy60_1();
        this.Occupancy60_2 = status.getOccupancy60_2();
        this.Occupancy120_0 = status.getOccupancy120_0();
        this.Occupancy120_1 = status.getOccupancy120_1();
        this.Occupancy120_2 = status.getOccupancy120_2();
    }
}
