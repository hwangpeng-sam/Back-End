package com.example.plugissue.station.controller;

import com.example.plugissue.station.controller.dto.SimpleStationDto;
import com.example.plugissue.station.controller.dto.StationListDto;
import com.example.plugissue.station.entity.Station;
import com.example.plugissue.station.service.StationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;
    @ResponseBody
    @GetMapping("/station")
    public ResponseEntity<StationListDto> getStationList(
            @RequestParam("lat")Double lat,
            @RequestParam("lng")Double lng,
            @RequestParam("range") Integer range)
    {
        List<Station> findList = stationService.findByLoc(lat,lng,range);
        List<SimpleStationDto> dtoList = findList.stream().map(SimpleStationDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(new StationListDto(dtoList));
    }

}
