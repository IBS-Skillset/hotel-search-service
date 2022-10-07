package com.hotel.api.search.mappers.roomAvailability;

import com.hotel.api.search.mappers.common.RequestContextMapper;
import com.hotel.api.search.model.HotelRoomAvailabilityRequest;
import com.hotel.service.roomavailability.RoomAvailabilityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class RoomAvailabilityRequestBuilder {
    @Autowired
    RequestContextMapper requestContextMapper;

    public RoomAvailabilityRequest map(HotelRoomAvailabilityRequest request){
        RoomAvailabilityRequest.Builder roomAvailabilityRequest= RoomAvailabilityRequest.newBuilder();
        safeSetProtoField(roomAvailabilityRequest::setHotelCode, request.getHotelCode());
        safeSetProtoField(roomAvailabilityRequest::setStartDate, request.getCheckInDate());
        safeSetProtoField(roomAvailabilityRequest::setEndDate, request.getCheckOutDate());
        safeSetProtoField(roomAvailabilityRequest::setLanguageCode, request.getLanguageCode());
        safeSetProtoField(roomAvailabilityRequest::setHomeCountryCode, request.getCountryCode());
        safeSetProtoField(roomAvailabilityRequest::setRoomCount, request.getRoomCount());
        safeSetProtoField(roomAvailabilityRequest::setNightsNeeded, request.getNoOfNights());
        safeSetProtoField(roomAvailabilityRequest::setOccupancy, request.getOccupancy());
        safeSetProtoField(roomAvailabilityRequest::setRequestContext, requestContextMapper.map());
        return roomAvailabilityRequest.build();
    }
}
