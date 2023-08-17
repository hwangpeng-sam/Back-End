package com.example.plugissue.station.repository;

import com.example.plugissue.station.entity.Station;
import com.example.plugissue.station.service.StationService;
import com.example.plugissue.status.entity.Status;
import com.example.plugissue.status.repository.StatusRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@SpringBootTest
@Transactional
public class stationRepositoryTest {

    @Autowired
    StationRepository stationRepository;
    @Autowired
    StatusRepository statusRepository;

    @Test
    void getStationList(){
        //given
        Station station = new Station(1L, 127.33434214, 38.954859, "보라매사옥","보라매어쩌구");
        stationRepository.save(station);
        Status status = new Status(1L,1,1,1,1,1,1,station);
        statusRepository.save(status);
        //when
        List<Object[]> res = stationRepository.findStationsByLoc(38.954859, 127.33434214,1.0);
        //then
        System.out.println(res.get(0));
    }

    @Test
    void getStationDetail(){
        //given

        //when

        //then
    }
}
