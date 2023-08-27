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
    @Column(name = "Sid",nullable = false)
    private Integer sId;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

    @Column(name = "Sname", nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 200)
    private String address;

    @Column
    private Integer slow;

    @Column
    private Integer fast;

}
