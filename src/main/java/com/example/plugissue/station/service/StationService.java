package com.example.plugissue.station.service;

import com.example.plugissue.station.controller.dto.StationStatusDto;
import com.example.plugissue.station.entity.Station;
import com.example.plugissue.station.repository.StationRepository;
import com.example.plugissue.status.entity.Status;
import com.example.plugissue.status.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;
    private final StatusRepository statusRepository;

    public List<StationStatusDto> findStationsStatusByLoc(Double lat, Double lng, Integer range) {
        List<Object[]> queryResult = stationRepository.findStationsByLoc(lat, lng, range);
        List<StationStatusDto> dtos = new ArrayList<>();

        for (Object[] objects : queryResult) {
            Station station = (Station) objects[0];
            Status status = (Status) objects[1];
            dtos.add(new StationStatusDto(station, status));
        }
        return dtos;
    }

    public StationStatusDto findById(Long stationId) {
        Object[] queryResult = stationRepository.findStationById(stationId);

        Station station = (Station) queryResult[0];
        Status status = (Status) queryResult[1];

        StationStatusDto stationStatusDto = new StationStatusDto(station,status);

        return stationStatusDto;
//        return stationRepository.findById(stationId).orElseThrow();
    }
}
