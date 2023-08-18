package com.example.plugissue.station.service;

import com.example.plugissue.exception.notfound.NearStationsNotFoundException;
import com.example.plugissue.exception.notfound.StationNotFoundException;
import com.example.plugissue.exception.notfound.StationsNotFoundException;
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

    /**
     * 사용자의 현재 위치 기준으로 range 내에 있는 충전소 목록 조회
     * @param lat 사용자의 현재 위치 중 위도
     * @param lng 사용자의 현재 위치 중 경도
     * @param range 검색 범위
     * @return 충전소 목록 리스트
     */
    public List<StationStatusDto> findStationsStatusByLoc(Double lat, Double lng, Double range) {
        List<Object[]> queryResult = stationRepository.findStationsByLoc(lat, lng, range);
        List<StationStatusDto> stationStatusDtoList = new ArrayList<>();

        if (queryResult.isEmpty()){
            throw new StationsNotFoundException();
        }
        else{
            for (Object[] objects : queryResult) {
                Station station = (Station) objects[0];
                Status status = (Status) objects[1];
                stationStatusDtoList.add(new StationStatusDto(station, status));
            }

            return stationStatusDtoList;
        }

    }

    public List<StationStatusDto> findById(Long stationId) {
//        StationStatusDto dto = stationRepository.findStationById(stationId);
//
//        return dto;
        List<Object[]> queryResult = stationRepository.findStationById(stationId);
        if(queryResult.isEmpty()){
            throw new StationNotFoundException();
        }
        else{
            List<StationStatusDto> dtos = new ArrayList<>();

            for (Object[] objects : queryResult) {
                Station station = (Station) objects[0];
                Status status = (Status) objects[1];
                dtos.add(new StationStatusDto(station, status));
            }
            return dtos;
        }

//        Station station = (Station) queryResult[0];
//        Status status = (Status) queryResult[1];
//
//        StationStatusDto stationStatusDto = new StationStatusDto(station,status);
//
//        return stationStatusDto;
//        return stationRepository.findById(stationId).orElseThrow();
//    }
    }
    public List<StationStatusDto> findNearStations(Double lat, Double lng) {
        List<Object[]> queryResult = stationRepository.findStationsNearby(lat, lng);
        if(queryResult.isEmpty()){
            throw new NearStationsNotFoundException();
        }
        else{
            List<StationStatusDto> dtos = new ArrayList<>();

            for (Object[] objects : queryResult) {
                Station station = (Station) objects[0];
                Status status = (Status) objects[1];
                dtos.add(new StationStatusDto(station, status));
            }
            return dtos;
        }

    }
}
