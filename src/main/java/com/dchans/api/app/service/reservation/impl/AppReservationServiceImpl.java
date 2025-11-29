package com.dchans.api.app.service.reservation.impl;

import com.dchans.api.app.dao.reservation.AppReservationDao;
import com.dchans.api.app.dto.reservation.AppReservationDto;
import com.dchans.api.app.service.reservation.AppReservationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppReservationServiceImpl implements AppReservationService {
    @Resource(name = "AppReservationDao")
    private AppReservationDao appReservationDao;
    private static final String NAMESPACE = "com.app.reservation.";

    @Override
    public AppReservationDto selectAppStoreReservationData(AppReservationDto appReservationDto) {
        AppReservationDto response = appReservationDao.selectStoreReservationDetail(NAMESPACE + "selectStoreReservationDetail", appReservationDto);
        List<String> businessHours = generateTimeList(
                response.getStartTime(),
                response.getEndTime()
        );
        response.setBusinessHours(businessHours);
        //response.setReviewDto(appReservationDao.selectReservedTimeList(NAMESPACE + "selectReservedTimeList", appReservationDto));
        return response;
    }

    @Override
    public AppReservationDto selectAppStoreMyReservationData(AppReservationDto appReservationDto) {
        AppReservationDto reservationDto = new AppReservationDto();
        reservationDto.setReverservationResponseDtos(appReservationDao.selectAppStoreMyReservationData(NAMESPACE + "selectAppStoreMyReservationData", appReservationDto));
        return reservationDto;
    }

    private List<String> generateTimeList(String startTime, String endTime) {
        List<String> timeList = new ArrayList<>();
        LocalTime current = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);

        while (!current.isAfter(end)) {
            timeList.add(current.format(DateTimeFormatter.ofPattern("HH:mm")));
            current = current.plusHours(1);
        }

        return timeList;
    }

}
