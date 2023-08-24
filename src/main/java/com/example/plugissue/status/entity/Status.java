package com.example.plugissue.status.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "occupancy")
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Status {

    @Id
    @Column(name = "Sid", nullable = false)
    private Long id;

    @Column
    private Integer Occupancy0; // 현재상태 라벨링 컬럼

    @Column
    private Double Occupancy20_0; // 0,1,2 로 구분

    @Column
    private Double Occupancy20_1;

    @Column
    private Double Occupancy20_2;

    @Column
    private Double Occupancy40_0;

    @Column
    private Double Occupancy40_1;

    @Column
    private Double Occupancy40_2;

    @Column
    private Double Occupancy60_0;

    @Column
    private Double Occupancy60_1;

    @Column
    private Double Occupancy60_2;

    @Column
    private Double Occupancy120_0;

    @Column
    private Double Occupancy120_1;

    @Column
    private Double Occupancy120_2;


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
