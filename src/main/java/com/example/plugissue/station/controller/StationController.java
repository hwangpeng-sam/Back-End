package com.example.plugissue.station.controller;

import com.example.plugissue.station.controller.dto.StationDto;
import com.example.plugissue.station.controller.dto.StationStatusDto;
import com.example.plugissue.station.entity.Station;
import com.example.plugissue.station.service.StationService;
import com.example.plugissue.status.entity.Status;
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
    public ResponseEntity<StationStatusDto> getStationDetails(
            @PathVariable("sId") Long stationId
    ){
        StationStatusDto stationStatusDto = stationService.findById(stationId);
        return ResponseEntity.ok(stationStatusDto);
    }

}
