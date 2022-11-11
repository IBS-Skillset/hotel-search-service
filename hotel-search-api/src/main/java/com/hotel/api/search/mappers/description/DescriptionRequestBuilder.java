package com.hotel.api.search.mappers.description;

import com.hotel.api.search.mappers.common.RequestContextMapper;
import com.hotel.api.search.model.DescriptionRequest;
import com.hotel.service.description.HotelDescriptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class DescriptionRequestBuilder {
    @Autowired
    private RequestContextMapper requestContextMapper;


    public HotelDescriptionRequest map(DescriptionRequest request) {
        HotelDescriptionRequest.Builder descriptionRequest = HotelDescriptionRequest.newBuilder();
        safeSetProtoField(descriptionRequest::setHotelCode, request.getHotelCode());
        safeSetProtoField(descriptionRequest::setStartDate, request.getCheckInDate());
        safeSetProtoField(descriptionRequest::setEndDate, request.getCheckOutDate());
        safeSetProtoField(descriptionRequest::setLanguageCode, request.getLanguageCode());
        safeSetProtoField(descriptionRequest::setCountryOfResidence, request.getCountryCode());
        safeSetProtoField(descriptionRequest::setRequestContext, requestContextMapper.map());
        return descriptionRequest.build();
    }
}
