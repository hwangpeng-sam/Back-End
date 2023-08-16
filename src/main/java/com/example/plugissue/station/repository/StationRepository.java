package com.example.plugissue.station.repository;

import com.example.plugissue.station.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StationRepository extends JpaRepository<Station,Long> {

    @Query("SELECT s, st FROM Station s " +
            "LEFT JOIN Status st ON s.sId = st.station.sId " +
            "WHERE 6371 * acos(" +
            "cos(radians(:lat)) * cos(radians(s.latitude)) * " +
            "cos(radians(s.longitude) - radians(:lng)) + " +
            "sin(radians(:lat)) * sin(radians(s.latitude))" +
            ") <= :range")
    List<Object[]> findStationsByLoc(@Param("lat") Double lat, @Param("lng") Double lng, @Param("range") Integer range);

    @Query("SELECT s, st FROM Station s, Status st " +
            "WHERE s.sId = st.station.sId AND s.sId = :sId")
    Object[] findStationById(@PathVariable("stationId") Long sId);

}
