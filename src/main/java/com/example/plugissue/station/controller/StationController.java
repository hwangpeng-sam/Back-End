package com.example.plugissue.station.controller;

import com.example.plugissue.station.controller.dto.StationStatusDto;
import com.example.plugissue.station.service.StationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;
    @ResponseBody
    @GetMapping("/station")
    public ResponseEntity<List<StationStatusDto>> getStationList(
            @RequestParam("lat")Double lat,
            @RequestParam("lng")Double lng,
            @RequestParam("range") Double range)
    {
        List<StationStatusDto> stationStatusDtoList= stationService.findStationsStatusByLoc(lat, lng, range);
        return ResponseEntity.ok(stationStatusDtoList);
    }

    @ResponseBody
    @GetMapping("/station/{sId}")
    public ResponseEntity<List<StationStatusDto>>getStationDetails(
            @PathVariable("sId") Long stationId
    ){
        List<StationStatusDto> stationStatusDto = stationService.findById(stationId);
        return ResponseEntity.ok(stationStatusDto);
    }

    @ResponseBody
    @GetMapping("/nav/near")
    public ResponseEntity<List<StationStatusDto>>getNearStations(
            @RequestParam("lat") Double lat,
            @RequestParam("lng") Double lng
    ){
        List<StationStatusDto> stationStatusDtoList = stationService.findNearStations(lat,lng);
        return ResponseEntity.ok(stationStatusDtoList);
    }
}
