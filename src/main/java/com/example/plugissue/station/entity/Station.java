package com.example.plugissue.station.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
@Table(name = "station")
@NoArgsConstructor(access =AccessLevel.PROTECTED) // 생성자를 통해서 값 변경 목적으로 접근하는 메시지들 차단 => protected Station() 코드 자동 생성
@AllArgsConstructor
public class Station {

    @Id
    @Column(name = "station_id", nullable = false)
    private Long sId;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 200)
    private String address;

}
