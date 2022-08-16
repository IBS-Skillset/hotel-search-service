package com.hotel.api.search.mappers.availability.request;

import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.api.search.util.APIConstants;
import com.hotel.api.search.util.APIUtils;
import com.hotel.service.availability.HotelAvailabilityRequest;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class AvailabilityRequestBuilder {

    private final RequestContextMapper requestContextMapper;


    public AvailabilityRequestBuilder(RequestContextMapper requestContextMapper) {
        this.requestContextMapper = requestContextMapper;
    }

    public HotelAvailabilityRequest map(HotelAvailableRequest hotelAvailableRequest) {
        HotelAvailabilityRequest.Builder getHotelAvailabilityBuilder = HotelAvailabilityRequest.newBuilder();
        safeSetProtoField(getHotelAvailabilityBuilder::setRequestContext, requestContextMapper.map());
        safeSetProtoField(getHotelAvailabilityBuilder::setLatitude, hotelAvailableRequest.getLatitude());
        safeSetProtoField(getHotelAvailabilityBuilder::setLongitude, hotelAvailableRequest.getLongitude());
        safeSetProtoField(getHotelAvailabilityBuilder::setStartDate, hotelAvailableRequest.getCheckInDate());
        safeSetProtoField(getHotelAvailabilityBuilder::setEndDate, hotelAvailableRequest.getCheckOutDate());
        safeSetProtoField(getHotelAvailabilityBuilder::setLanguageCode, APIConstants.LANGUAGE_CODE);
        safeSetProtoField(getHotelAvailabilityBuilder::setCountryCode, APIConstants.COUNTRY_CODE);
        safeSetProtoField(getHotelAvailabilityBuilder::setOccupancy, APIConstants.OCCUPANCY);
        safeSetProtoField(getHotelAvailabilityBuilder::setRadius, APIConstants.RADIUS);
        safeSetProtoField(getHotelAvailabilityBuilder::setRoomCount, APIConstants.ROOM_COUNT);
        return getHotelAvailabilityBuilder.build();


    }
}
