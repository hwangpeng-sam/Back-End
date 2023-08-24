package com.example.plugissue.station.repository;

import com.example.plugissue.station.controller.dto.StationStatusDto;
import com.example.plugissue.station.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StationRepository extends JpaRepository<Station,Long> {

    @Query("SELECT s, oc FROM Station s " +
            "LEFT JOIN occupancy " +
            "oc ON s.sId = oc.id " +
            "WHERE 6371 * acos(" +
            "cos(radians(:lat)) * cos(radians(s.latitude)) * " +
            "cos(radians(s.longitude) - radians(:lng)) + " +
            "sin(radians(:lat)) * sin(radians(s.latitude))" +
            ") <= 3")
    List<Object[]> findStationsByLoc(@Param("lat") Double lat, @Param("lng") Double lng); // 범위 3km 로 고정

    @Query("SELECT s,oc FROM Station s " +
            "LEFT JOIN occupancy " +
            "oc ON s.sId = oc.id " +
            "WHERE s.sId = :stationId")
    List<Object[]> findStationById(@Param("stationId") Long stationId);


    @Query("SELECT s, oc FROM Station s " +
            "LEFT JOIN occupancy " +
            "oc ON s.sId = oc.id " +
            "WHERE 6371 * acos(" +
            "cos(radians(:lat)) * cos(radians(s.latitude)) * " +
            "cos(radians(s.longitude) - radians(:lng)) + " +
            "sin(radians(:lat)) * sin(radians(s.latitude))" +
            ") <= 3 ")
    List<Object[]> findStationsNearby(@Param("lat") Double lat, @Param("lng") Double lng); // 범위 3km 로 고정
}
