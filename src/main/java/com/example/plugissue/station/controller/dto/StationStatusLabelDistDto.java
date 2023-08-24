package com.example.plugissue.station.controller.dto;

import com.example.plugissue.station.entity.Station;
import com.example.plugissue.status.entity.Status;
import lombok.Getter;

import java.util.List;

@Getter
public class StationStatusLabelDistDto {

    private Station station; // station 정보
    private Integer Occupancy20;
    private Integer Occupancy40;
    private Integer Occupancy60;
    private Integer Occupancy120; // status 정보

    private Double distance;

    public static int getMaxIndex(List<Double> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List should not be empty or null.");
        }

        int maxIndex = 0;
        Double maxValue = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > maxValue) {
                maxValue = list.get(i);
                maxIndex = i;
            }
        }

        return maxIndex;
    }


    public StationStatusLabelDistDto(Station station,Status status, Double distance){
        this.station = station;
        this.Occupancy20 = getMaxIndex(List.of(status.getOccupancy20_0(),status.getOccupancy20_1(), status.getOccupancy20_2()));
        this.Occupancy40 = getMaxIndex(List.of(status.getOccupancy40_0(),status.getOccupancy40_1(), status.getOccupancy40_2()));
        this.Occupancy60 = getMaxIndex(List.of(status.getOccupancy60_0(),status.getOccupancy60_1(), status.getOccupancy60_2()));
        this.Occupancy120 = getMaxIndex(List.of(status.getOccupancy120_0(),status.getOccupancy120_1(), status.getOccupancy120_2()));
        this.distance = distance;
    }
}
