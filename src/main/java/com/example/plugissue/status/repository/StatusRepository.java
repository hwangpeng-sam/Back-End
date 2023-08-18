package com.example.plugissue.status.repository;

import com.example.plugissue.station.entity.Station;
import com.example.plugissue.status.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status,Long> {

    @Query("SELECT oc FROM occupancy oc WHERE oc.id IN (:stationIdsInRange)")
    List<Status> findStatusByStationIds(@Param("stationIdsInRange") List<Long> stationIdsInRange);
}
