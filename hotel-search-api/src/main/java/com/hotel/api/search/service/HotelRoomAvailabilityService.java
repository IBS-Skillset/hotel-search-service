package com.hotel.api.search.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hotel.api.search.adapter.HotelRoomAvailabilityResponseAdapter;
import com.hotel.api.search.mappers.roomAvailability.RoomAvailabilityRequestBuilder;
import com.hotel.api.search.model.HotelRoomAvailabilityRequest;
import com.hotel.service.roomavailability.HotelRoomAvailabilityServiceGrpc;
import com.hotel.service.roomavailability.RoomAvailabilityRequest;
import com.hotel.service.roomavailability.RoomAvailabilityResponse;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HotelRoomAvailabilityService {

    @Autowired
    RoomAvailabilityRequestBuilder requestBuilder;

    @GrpcClient("hotel-details-pad")
    HotelRoomAvailabilityServiceGrpc.HotelRoomAvailabilityServiceBlockingStub hotelRoomAvailabilityServiceBlockingStub;

    public String getRoomAvailabilityService(HotelRoomAvailabilityRequest request) {
        log.info(request.toString());
        RoomAvailabilityRequest roomAvailabilityRequest=requestBuilder.map(request);
        log.info("Invoking grpc service for hotel Room Availability request " + roomAvailabilityRequest.toString());
        RoomAvailabilityResponse response=hotelRoomAvailabilityServiceBlockingStub.getRoomAvailability(roomAvailabilityRequest);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(RoomAvailabilityResponse.class, new HotelRoomAvailabilityResponseAdapter()).create();
        String jsonResponse = gson.toJson(response);
        log.info("Returning the JSON Response " + jsonResponse);
        return jsonResponse;
    }
}
