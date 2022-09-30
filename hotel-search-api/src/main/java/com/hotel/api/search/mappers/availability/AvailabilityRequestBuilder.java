package com.hotel.api.search.mappers.availability;

import com.hotel.api.search.mappers.common.RequestContextMapper;
import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.api.search.util.APIConstants;
import com.hotel.service.availability.HotelAvailabilityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class AvailabilityRequestBuilder {

    @Autowired
    private RequestContextMapper requestContextMapper;

    public HotelAvailabilityRequest map(HotelAvailableRequest hotelAvailableRequest) {
        HotelAvailabilityRequest.Builder getHotelAvailabilityBuilder = HotelAvailabilityRequest.newBuilder();
        safeSetProtoField(getHotelAvailabilityBuilder::setRequestContext, requestContextMapper.map());
        safeSetProtoField(getHotelAvailabilityBuilder::setLatitude, hotelAvailableRequest.getLatitude());
        safeSetProtoField(getHotelAvailabilityBuilder::setLongitude, hotelAvailableRequest.getLongitude());
        safeSetProtoField(getHotelAvailabilityBuilder::setStartDate, mapDate(hotelAvailableRequest.getCheckInDate()));
        safeSetProtoField(getHotelAvailabilityBuilder::setEndDate, mapDate(hotelAvailableRequest.getCheckOutDate()));
        safeSetProtoField(getHotelAvailabilityBuilder::setLanguageCode, APIConstants.LANGUAGE_CODE);
        safeSetProtoField(getHotelAvailabilityBuilder::setCountryCode, APIConstants.COUNTRY_CODE);
        safeSetProtoField(getHotelAvailabilityBuilder::setOccupancy, APIConstants.OCCUPANCY);
        safeSetProtoField(getHotelAvailabilityBuilder::setRadius, APIConstants.RADIUS);
        safeSetProtoField(getHotelAvailabilityBuilder::setRoomCount, APIConstants.ROOM_COUNT);
        return getHotelAvailabilityBuilder.build();

    }

    public String mapDate(String dateString) {
        return dateString.substring(0, 4) + '-' +
                dateString.substring(4, 6) + '-' +
                dateString.substring(6, 8);
    }
}
