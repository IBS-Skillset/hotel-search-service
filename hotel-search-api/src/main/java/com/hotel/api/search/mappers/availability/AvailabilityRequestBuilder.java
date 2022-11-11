package com.hotel.api.search.mappers.availability;

import com.hotel.api.search.mappers.common.RequestContextMapper;
import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.service.availability.HotelAvailabilityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class AvailabilityRequestBuilder {

    private final int radius;
    @Autowired
    private RequestContextMapper requestContextMapper;

    public AvailabilityRequestBuilder(@Value("${supplier.radius}") int radius) {
        this.radius = radius;
    }

    public HotelAvailabilityRequest map(HotelAvailableRequest hotelAvailableRequest) {
        HotelAvailabilityRequest.Builder getHotelAvailabilityBuilder = HotelAvailabilityRequest.newBuilder();
        safeSetProtoField(getHotelAvailabilityBuilder::setRequestContext, requestContextMapper.map());
        safeSetProtoField(getHotelAvailabilityBuilder::setLatitude, hotelAvailableRequest.getLatitude());
        safeSetProtoField(getHotelAvailabilityBuilder::setLongitude, hotelAvailableRequest.getLongitude());
        safeSetProtoField(getHotelAvailabilityBuilder::setStartDate, mapDate(hotelAvailableRequest.getCheckInDate()));
        safeSetProtoField(getHotelAvailabilityBuilder::setEndDate, mapDate(hotelAvailableRequest.getCheckOutDate()));
        safeSetProtoField(getHotelAvailabilityBuilder::setLanguageCode, hotelAvailableRequest.getLanguageCode());
        safeSetProtoField(getHotelAvailabilityBuilder::setCountryCode, hotelAvailableRequest.getCountryCode());
        safeSetProtoField(getHotelAvailabilityBuilder::setOccupancy, hotelAvailableRequest.getOccupancy());
        safeSetProtoField(getHotelAvailabilityBuilder::setRadius, radius);
        safeSetProtoField(getHotelAvailabilityBuilder::setRoomCount, hotelAvailableRequest.getRoomCount());
        return getHotelAvailabilityBuilder.build();

    }

    public String mapDate(String dateString) {
        return dateString.substring(0, 4) + '-' +
                dateString.substring(4, 6) + '-' +
                dateString.substring(6, 8);
    }
}
