package com.example.plugissue.station.repository;

import com.example.plugissue.station.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StationRepository extends JpaRepository<Station,Long> {

    @Query("SELECT s FROM Station s WHERE " +
            "6371 * acos(" +
            "cos(radians(:lat)) * cos(radians(s.latitude)) * " +
            "cos(radians(s.longitude) - radians(:lng)) + " +
            "sin(radians(:lat)) * sin(radians(s.latitude))" +
            ") <= :range")
    List<Station> findStationsByLoc(@Param("lat") Double lat, @Param("lng") Double lng, @Param("range") Integer range);

}
