package com.example.plugissue.station.service;

import com.example.plugissue.common.CalculateDistance;
import com.example.plugissue.exception.notfound.NearStationsNotFoundException;
import com.example.plugissue.exception.notfound.StationNotFoundException;
import com.example.plugissue.exception.notfound.StationsNotFoundException;
import com.example.plugissue.station.controller.dto.*;
import com.example.plugissue.station.entity.Station;
import com.example.plugissue.station.repository.StationRepository;
import com.example.plugissue.status.entity.Status;
import com.example.plugissue.usages.entity.Usages;
import com.example.plugissue.usages.repository.UsagesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
    private final UsagesRepository usagesRepository;

    /**
     * 사용자의 현재 위치 기준으로 range 내에 있는 충전소 목록 조회
     * @param lat 사용자의 현재 위치 위도
     * @param lng 사용자의 현재 위치 경도
     * @return 충전소 목록 리스트
     */
    public FinalDto findStationsStatusByLoc(Double lat, Double lng) {


        List<Object[]> queryResult = stationRepository.findStationsByLoc(lat, lng);
        List<StationStatusLabelDistDto> dtos = new ArrayList<>();

        if (queryResult.isEmpty()){
            throw new StationsNotFoundException();
        }
        else{
            for (Object[] objects : queryResult) {
                Station station = (Station) objects[0];
                Status status = (Status) objects[1];
                double distance = CalculateDistance.calculateDistance(((Station) objects[0]).getLatitude(),((Station) objects[0]).getLongitude(),lat,lng);
                dtos.add(new StationStatusLabelDistDto(station, status, distance));
            }

            return new FinalDto(200,"현재 위치 기준 주변 충전소 조회 성공",dtos);
//            return stationStatusDtoList;
        }

    }

    /**
     *
     * @param stationId 상세 정보를 원하는 충전소의 id
     * @param time 현재 시간 타임스탬프
     * @return 해당 충전소의 상세 정보
     */
    public FinalDto findById(Integer stationId,LocalDateTime time) {
        // time 을 1년6개월 빼고 4주를 더 빼
        // 거기서 이제 시간을 20으로 나눠서 몫 * 20 분 기준으로 +20분40분60분120분 구해서 저장
        String statId = "Sid_" + stationId;
        Period subtractPer = Period.ofYears(1).plusMonths(6);
        LocalDate subtractDate = time.toLocalDate().minus(subtractPer); // 1년 6개월 뺀거
        LocalTime adSec = time.toLocalTime().withSecond(0);
        LocalDateTime subtractTime = subtractDate.atTime(adSec);

        subtractTime = subtractTime.minusMinutes(subtractTime.getMinute()).plusMinutes(20 * (subtractTime.getMinute() / 20));
//        subtractTime = subtractTime.minusSeconds(subtractTime.getSecond());

        LocalDateTime subtract4Week = subtractTime.minusWeeks(4); // 4주 더 뺀 날짜 -> 4주전
        LocalDateTime subtract3Week = subtractTime.minusWeeks(3); // 3주 더 뺀 날짜 -> 3주전
        LocalDateTime subtract2Week = subtractTime.minusWeeks(2); // 2주 더 뺀 날짜 -> 2주전
        LocalDateTime subtract1Week = subtractTime.minusWeeks(1); // 1주 더 뺀 날짜 -> 1주전

        List<LocalDateTime> calc4Week = calcMin(subtract4Week); // 4주전 해당 시간 20분,40분,60분,120분 뒤 시각
        List<LocalDateTime> calc3Week = calcMin(subtract3Week);
        List<LocalDateTime> calc2Week = calcMin(subtract2Week);
        List<LocalDateTime> calc1Week = calcMin(subtract1Week);


        LocalDateTime before4Hours = subtractTime.minusHours(4);
        LocalDateTime before3Hours = subtractTime.minusHours(3);
        LocalDateTime before2Hours = subtractTime.minusHours(2);
        LocalDateTime before1Hours = subtractTime.minusHours(1);

        List<LocalDateTime> listHours = new ArrayList<>();
        listHours.add(before4Hours);
        listHours.add(before3Hours);
        listHours.add(before2Hours);
        listHours.add(before1Hours);

        List<Object[]> resHours = new ArrayList<>();

        resHours = getList(listHours,resHours);

        List<Integer> chargers4 = new ArrayList<>();
        chargers4 = getChargers4(resHours,chargers4,statId);

        Double charAvg4;

        //시간에 있는걸 다 가져와서 sId 에 해당하는걸 뽑아서 dto 에 넣기
        List<Object[]> queryResult = stationRepository.findStationById(stationId);

//        Object[] res20 = usagesRepository.findByTime(time20);
//        Object[] res40 = usagesRepository.findByTime(time40);
//        Usages[] res60 = usagesRepository.findByTime(time60);
//        Usages res120 = usagesRepository.findByTime(time120);


        List<Object[]> res4 = new ArrayList<>();
        List<Object[]> res3 = new ArrayList<>();
        List<Object[]> res2 = new ArrayList<>();
        List<Object[]> res1 = new ArrayList<>();

        res4 = getList(calc4Week,res4); // 20분40분60분120분 후 행 저장,,,
        res3 = getList(calc3Week,res3);
        res2 = getList(calc2Week,res2);
        res1 = getList(calc1Week,res1);

        List<Integer> chargers20 = new ArrayList<>();
        List<Integer> chargers40 = new ArrayList<>();
        List<Integer> chargers60 = new ArrayList<>();
        List<Integer> chargers120 = new ArrayList<>();

        chargers20 = getChargers20(res4,res3,res2,res1,chargers20,statId);
        chargers40 = getChargers40(res4,res3,res2,res1,chargers40,statId);
        chargers60 = getChargers60(res4,res3,res2,res1,chargers60,statId);
        chargers120 = getChargers120(res4,res3,res2,res1,chargers120,statId);

        Double charAvg20;
        Double charAvg40;
        Double charAvg60;
        Double charAvg120;

        if(queryResult.isEmpty()){
            throw new StationNotFoundException();
        }
        else{
            List<StationStatusAvgDto> dtos = new ArrayList<>();

            for (Object[] objects : queryResult) {
                Station station = (Station) objects[0];
                Status status = (Status) objects[1];
                charAvg20 = calcAvg(chargers20);
                charAvg40 = calcAvg(chargers40);
                charAvg60 = calcAvg(chargers60);
                charAvg120 = calcAvg(chargers120);
                charAvg4 = calcAvg(chargers4);
                dtos.add(new StationStatusAvgDto(station, status,charAvg20,charAvg40,charAvg60,charAvg120,charAvg4));
            }
            return new FinalDto(200,"id 에 해당하는 충전소 정보 조회 성공", dtos);
        }
    }

    /**
     *
     * @param lat 목적지 위도
     * @param lng 목적지 경도
     * @return 충전소 목록
     */
    public FinalDto findNearStations(Double lat, Double lng) {
        List<Object[]> queryResult = stationRepository.findStationsNearby(lat, lng);
        if(queryResult.size()<=1){
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
            List<StationStatusDistDto> finalList = dtos.stream() // 거리기준 sort
                    .sorted(Comparator.comparingDouble(dto->dto.getDistance()))
                    .collect(Collectors.toList());
//
//            if (finalList.size() < 4) // 충전소 총 개수가 3개가 안 될 경우
//                dtos = finalList.subList(1,finalList.size());
//            else
//                dtos = finalList.subList(1,4);


            return new FinalDto(200,"목적지 주변 최적 충전소 조회 성공",dtos);
//            return dtos;
        }

    }

    // findById 에 필요한 함수 정의

    // 각 주에 따른 20분,40분,60분,120분 후의 시간 계산해서 배열에 넣기
    private List<LocalDateTime> calcMin(LocalDateTime time){
        List<LocalDateTime> list = new ArrayList<>();

        Integer min = time.getMinute();
        LocalDateTime setTime = time.minusMinutes(min).plusMinutes(20 * (min / 20)); // 시간을 0으로 만들고 시간 / 20 의 몫에 20을 곱해서 더해줌
//        setTime = setTime.minusSeconds(setTime.getSecond());

        LocalDateTime time20 = time.plusMinutes(20);
        LocalDateTime time40 = time.plusMinutes(40);
        LocalDateTime time60 = time.plusMinutes(60);
        LocalDateTime time120 = time.plusMinutes(120);

        list.add(time20);
        list.add(time40);
        list.add(time60);
        list.add(time120);

        return list;
    }



    // 각 주마다 시간에 따른 각 sid에 해당하는 점유 대수 배열 구하기
    private List<Object[]> getList(List<LocalDateTime> calcTime, List<Object[]> res){
        for (LocalDateTime calc : calcTime) {
            String cal = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(calc);
            LocalDateTime cals = LocalDateTime.parse(cal, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            res.add(usagesRepository.findByTime(cals));
        }
        return res;
    }

    // 20분 뒤 점유 상태 조회
    private List<Integer> getChargers20(List<Object[]> li1,List<Object[]> li2,List<Object[]> li3,List<Object[]> li4,
                                      List<Integer> chargers, String id)  {
        Usages usage1 = (Usages) li1.get(0)[0];
        Usages usage2 = (Usages) li2.get(0)[0];
        Usages usage3 = (Usages) li3.get(0)[0];
        Usages usage4 = (Usages) li4.get(0)[0];

        chargers.add(getId(usage1,id));
        chargers.add(getId(usage2,id));
        chargers.add(getId(usage3,id));
        chargers.add(getId(usage4,id));

        return chargers;
    }

    // 40분 뒤 점유 상태 조회
    private List<Integer> getChargers40(List<Object[]> li1,List<Object[]> li2,List<Object[]> li3,List<Object[]> li4,
                                       List<Integer> chargers, String id)  {
        Usages usage1 = (Usages) li1.get(1)[0];
        Usages usage2 = (Usages) li2.get(1)[0];
        Usages usage3 = (Usages) li3.get(1)[0];
        Usages usage4 = (Usages) li4.get(1)[0];

        chargers.add(getId(usage1,id));
        chargers.add(getId(usage2,id));
        chargers.add(getId(usage3,id));
        chargers.add(getId(usage4,id));

        return chargers;
    }

    // 60분 뒤 점유 상태 조회
    private List<Integer> getChargers60(List<Object[]> li1,List<Object[]> li2,List<Object[]> li3,List<Object[]> li4,
                                       List<Integer> chargers, String id)  {
        Usages usage1 = (Usages) li1.get(2)[0];
        Usages usage2 = (Usages) li2.get(2)[0];
        Usages usage3 = (Usages) li3.get(2)[0];
        Usages usage4 = (Usages) li4.get(2)[0];

        chargers.add(getId(usage1,id));
        chargers.add(getId(usage2,id));
        chargers.add(getId(usage3,id));
        chargers.add(getId(usage4,id));

        return chargers;
    }

    // 120분 뒤 점유 상태 조회
    private List<Integer> getChargers120(List<Object[]> li1,List<Object[]> li2,List<Object[]> li3,List<Object[]> li4,
                                       List<Integer> chargers, String id)  {
        Usages usage1 = (Usages) li1.get(3)[0];
        Usages usage2 = (Usages) li2.get(3)[0];
        Usages usage3 = (Usages) li3.get(3)[0];
        Usages usage4 = (Usages) li4.get(3)[0];

        chargers.add(getId(usage1,id));
        chargers.add(getId(usage2,id));
        chargers.add(getId(usage3,id));
        chargers.add(getId(usage4,id));

        return chargers;
    }

    private List<Integer> getChargers4(List<Object[]> li1, List<Integer> chargers, String id)  {
        Usages usage1 = (Usages) li1.get(0)[0];
        chargers.add(getId(usage1,id));

        return chargers;
    }


    private Integer getId(Usages usages, String id){
        try {
            String methodName = "get" + id;
            Method method = Usages.class.getMethod(methodName);
            return (Integer) method.invoke(usages);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static double calcAvg(List<Integer> arr){
        Integer sum = 0;
        for (Integer num : arr){
            sum += num;
        }
        return (double) sum / arr.size();
    }
}
