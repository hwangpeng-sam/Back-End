package com.example.plugissue.status.entity;

import com.example.plugissue.station.entity.Station;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Integer occupancy_20;

    @Column
    private Integer occupancy_40;

    @Column
    private Integer occupancy_60;

    @Column
    private Integer occupancy_80;

    @Column
    private Integer occupancy_100;

    @Column
    private Integer occupancy_120;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;
}
