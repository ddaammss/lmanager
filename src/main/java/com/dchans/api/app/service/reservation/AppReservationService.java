package com.dchans.api.app.service.reservation;

import com.dchans.api.app.dto.reservation.AppReservationDto;

public interface AppReservationService {

    AppReservationDto selectAppStoreReservationData(AppReservationDto appReservationDto);

    AppReservationDto selectAppStoreMyReservationData(AppReservationDto appReservationDto);
}
