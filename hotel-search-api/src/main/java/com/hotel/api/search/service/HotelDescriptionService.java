package com.hotel.api.search.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hotel.api.search.adapter.HotelDescriptionResponseAdapter;
import com.hotel.api.search.mappers.description.DescriptionRequestBuilder;
import com.hotel.api.search.model.DescriptionRequest;
import com.hotel.service.description.HotelDescriptionRequest;
import com.hotel.service.description.HotelDescriptionResponse;
import com.hotel.service.description.HotelDescriptionServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HotelDescriptionService {

    @GrpcClient("hotel-details-pad")
    HotelDescriptionServiceGrpc.HotelDescriptionServiceBlockingStub hotelDescriptionServiceBlockingStub;

    @Autowired
    DescriptionRequestBuilder requestBuilder;

    public String service(DescriptionRequest request) {
        log.info(request.toString());
        HotelDescriptionRequest hotelDescriptionRequest = requestBuilder.map(request);
        log.info("Calling grpc service for hotel description request " + hotelDescriptionRequest.toString());
        HotelDescriptionResponse response = hotelDescriptionServiceBlockingStub.getHotelDescription(hotelDescriptionRequest);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(HotelDescriptionResponse.class, new HotelDescriptionResponseAdapter()).create();
        String jsonResponse = gson.toJson(response);
        log.info("Returning the JSON Response " + jsonResponse);
        return jsonResponse;

    }
}
