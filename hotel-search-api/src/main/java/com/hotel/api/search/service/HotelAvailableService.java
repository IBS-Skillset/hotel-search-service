package com.hotel.api.search.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hotel.api.search.adapter.HotelAvailabilityResponseAdapter;
import com.hotel.api.search.mappers.availability.request.AvailabilityRequestBuilder;
import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.service.availability.HotelAvailabilityRequest;
import com.hotel.service.availability.HotelAvailabilityResponse;
import com.hotel.service.availability.HotelServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class HotelAvailableService {

    @GrpcClient("hotel-availibility-pad")
    HotelServiceGrpc.HotelServiceBlockingStub hotelServiceBlockingStub;

    private final Logger logger = LoggerFactory.getLogger(HotelAvailableService.class);

    private final AvailabilityRequestBuilder availabilityRequestBuilder;

    public HotelAvailableService(AvailabilityRequestBuilder availabilityRequestBuilder) {
        this.availabilityRequestBuilder = availabilityRequestBuilder;
    }

    public String service(HotelAvailableRequest request){
        logger.info(request.toString());
        HotelAvailabilityRequest hotelAvailabilityRequest = availabilityRequestBuilder.map(request);
        logger.info("Calling grpc service for request");
        logger.info(hotelAvailabilityRequest.toString());
        HotelAvailabilityResponse response = hotelServiceBlockingStub.getHotelItem(hotelAvailabilityRequest);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(HotelAvailabilityResponse.class,new HotelAvailabilityResponseAdapter()).create();
        String jsonResponse = gson.toJson(response);
        logger.info("Returning the JSON Response");
        logger.info(jsonResponse);
        return jsonResponse;

    }
}
