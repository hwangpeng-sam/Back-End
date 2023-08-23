package com.example.plugissue.station.service;

import com.example.plugissue.common.CalculateDistance;
import com.example.plugissue.exception.notfound.NearStationsNotFoundException;
import com.example.plugissue.exception.notfound.StationNotFoundException;
import com.example.plugissue.exception.notfound.StationsNotFoundException;
import com.example.plugissue.station.controller.dto.FinalDto;
import com.example.plugissue.station.controller.dto.StationStatusDistDto;
import com.example.plugissue.station.controller.dto.StationStatusDto;
import com.example.plugissue.station.entity.Station;
import com.example.plugissue.station.repository.StationRepository;
import com.example.plugissue.status.entity.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.TrueFalseType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
     * @return 충전소 목록 리스트
     */
    public FinalDto findStationsStatusByLoc(Double lat, Double lng) {
        List<Object[]> queryResult = stationRepository.findStationsByLoc(lat, lng);
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

            return new FinalDto(200,"현재 위치 기준 주변 충전소 조회 성공",stationStatusDtoList);
//            return stationStatusDtoList;
        }

    }

    /**
     *
     * @param stationId 상세 정보를 원하는 충전소의 id
     * @return 해당 충전소의 상세 정보
     */
    public FinalDto findById(Long stationId) {
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
            return new FinalDto(200,"id 에 해당하는 충전소 정보 조회 성공", dtos);
//            return dtos;
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

    /**
     *
     * @param lat 목적지 위도
     * @param lng 목적지 경도
     * @return 목적지 주변 3km 내의 충전소 중 거리가 가장 가까운 충전소 3개(거리가 같을 경우 비어있을 확률이 더 높은걸 return)
     */
    public FinalDto findNearStations(Double lat, Double lng) {
        List<Object[]> queryResult = stationRepository.findStationsNearby(lat, lng);
        if(queryResult.size()==1){
            throw new NearStationsNotFoundException();
        }
        else{

            List<StationStatusDistDto> dtos = new ArrayList<>();

            for (Object[] objects : queryResult) {
                Station station = (Station) objects[0];
                Status status = (Status) objects[1];
                double distance = CalculateDistance.calculateDistance(((Station) objects[0]).getLatitude(),((Station) objects[0]).getLongitude(),lat,lng);
                dtos.add(new StationStatusDistDto(station, status, distance));
            }

//            List<StationStatusDistDto> sortedList = dtos.stream() // 점유 확률로 먼저 sort 하고
//                    .sorted(Comparator.comparingInt(dto-> -dto.getStatus().getOccupancy_40()))
//                    .collect(Collectors.toList());
//
//            List<StationStatusDistDto> finalList = sortedList.stream() // 최종적으로 거리 기준으로 sort
//                    .sorted(Comparator.comparingDouble(dto->dto.getDistance()))
//                    .collect(Collectors.toList());
//
//            if (finalList.size() < 4) // 충전소 총 개수가 3개가 안 될 경우
//                dtos = finalList.subList(1,finalList.size());
//            else
//                dtos = finalList.subList(1,4);


            return new FinalDto(200,"목적지 주변 최적 충전소 조회 성공",dtos);
//            return dtos;
        }

    }
}
