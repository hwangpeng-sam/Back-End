package com.example.plugissue.station.controller;

import com.example.plugissue.station.controller.dto.SimpleStationDto;
import com.example.plugissue.station.controller.dto.StationDto;
import com.example.plugissue.station.controller.dto.StationListDto;
import com.example.plugissue.station.controller.dto.StationStatusDto;
import com.example.plugissue.station.entity.Station;
import com.example.plugissue.station.service.StationService;
import com.example.plugissue.status.entity.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;
    @ResponseBody
    @GetMapping("/station")
    public List<StationStatusDto> getStationList(
            @RequestParam("lat")Double lat,
            @RequestParam("lng")Double lng,
            @RequestParam("range") Integer range)
    {
        return stationService.findStationsStatusByLoc(lat, lng, range);
    }

    @GetMapping("/station/{sId}")
    public ResponseEntity<StationDto> getStationDetails(
            @PathVariable("sId") Long stationId
    ){
        Station station = stationService.findById(stationId);
        return ResponseEntity.ok(new StationDto(station));
    }

}
