package com.hotel.api.search.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hotel.api.search.adapter.HotelAvailabilityResponseAdapter;
import com.hotel.api.search.mappers.availability.AvailabilityRequestBuilder;
import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.service.availability.HotelAvailabilityRequest;
import com.hotel.service.availability.HotelAvailabilityResponse;
import com.hotel.service.availability.HotelServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class HotelAvailabilityService {

    @GrpcClient("hotel-availibility-pad")
    HotelServiceGrpc.HotelServiceBlockingStub hotelServiceBlockingStub;

    @Autowired
    private AvailabilityRequestBuilder availabilityRequestBuilder;

    public String service(HotelAvailableRequest request) {
        log.info(request.toString());
        HotelAvailabilityRequest hotelAvailabilityRequest = availabilityRequestBuilder.map(request);
        log.info("Calling grpc service for request " + hotelAvailabilityRequest.toString());
        HotelAvailabilityResponse response = hotelServiceBlockingStub.getHotelItem(hotelAvailabilityRequest);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(HotelAvailabilityResponse.class, new HotelAvailabilityResponseAdapter()).create();
        String jsonResponse = gson.toJson(response);
        log.info("Returning the JSON Response " + jsonResponse);
        return jsonResponse;

    }
}
