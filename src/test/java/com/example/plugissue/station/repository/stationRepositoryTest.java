//package com.example.plugissue.station.repository;
//
//import com.example.plugissue.station.controller.dto.StationStatusDto;
//import com.example.plugissue.station.entity.Station;
//import com.example.plugissue.station.service.StationService;
//import com.example.plugissue.status.entity.Status;
//import com.example.plugissue.status.repository.StatusRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Objects;
//
//@SpringBootTest
//@Transactional
//public class stationRepositoryTest {
//
//    @Autowired
//    StationRepository stationRepository;
//    @Autowired
//    StatusRepository statusRepository;
//    StationService stationService;
//    @Test
//    void getStationList(){
//        //given
//        //when
////        List<Object[]> res = stationRepository.findStationsByLoc(128.905083, 37.744127,1.0);
//        List<StationStatusDto> dtos = stationService.findStationsStatusByLoc(128.905083, 37.744127,100.0);
//        //then
//        System.out.println(dtos.get(0));
//    }
//
//    @Test
//    void getStationDetail(){
//        //given
//
//        //when
//
//        //then
//    }
//}
