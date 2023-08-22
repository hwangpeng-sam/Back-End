package com.example.plugissue.status.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "occupancy")
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Status {

    @Id
    @Column(name = "Sid", nullable = false)
    private Long sid;

    @Column
    private Integer Occupancy_20;

    @Column
    private Integer Occupancy_40;

    @Column
    private Integer Occupancy_60;

    @Column
    private Integer Occupancy_80;

    @Column
    private Integer Occupancy_100;

    @Column
    private Integer Occupancy_120;


//    @Builder
//    public Status(Integer occupancy_20,Integer occupancy_40,Integer occupancy_60, Integer occupancy_80, Integer occupancy_100, Integer occupancy_120,Station station){
//        this.station = station;
//        this.Occupancy_20 = occupancy_20;
//        this.Occupancy_40 = occupancy_40;
//        this.Occupancy_60 = occupancy_60;
//        this.Occupancy_80 = occupancy_80;
//        this.Occupancy_100 = occupancy_100;
//        this.Occupancy_120 = occupancy_120;
//    }
}
