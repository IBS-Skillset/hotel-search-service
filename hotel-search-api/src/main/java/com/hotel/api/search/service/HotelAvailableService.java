package com.hotel.api.search.service;

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

    @GrpcClient("getHotelItem")
    HotelServiceGrpc.HotelServiceBlockingStub hotelServiceBlockingStub;

    private final Logger logger = LoggerFactory.getLogger(HotelAvailableService.class);

    private final AvailabilityRequestBuilder availabilityRequestBuilder;

    public HotelAvailableService(AvailabilityRequestBuilder availabilityRequestBuilder) {
        this.availabilityRequestBuilder = availabilityRequestBuilder;
    }

    //Return type needs to be changed to json format for hotel available response
    public HotelAvailabilityResponse service(HotelAvailableRequest request) {
        logger.info(request.toString());
        HotelAvailabilityRequest hotelAvailabilityRequest = availabilityRequestBuilder.map(request);
        logger.info("Calling grpc service for request");
        logger.info(hotelAvailabilityRequest.toString());
        HotelAvailabilityResponse response = hotelServiceBlockingStub.getHotelItem(hotelAvailabilityRequest);
        return response;

    }
}
