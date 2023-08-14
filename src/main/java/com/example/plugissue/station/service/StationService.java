package com.example.plugissue.station.service;

import com.example.plugissue.station.entity.Station;
import com.example.plugissue.station.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;

    public List<Station> findByLoc(Double lat,Double lng, Integer range){
        return stationRepository.findStationsByLoc(lat,lng,range);
    }
}
