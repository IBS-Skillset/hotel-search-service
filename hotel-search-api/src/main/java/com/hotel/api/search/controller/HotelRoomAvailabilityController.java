package com.hotel.api.search.controller;

import com.hotel.api.search.model.HotelRoomAvailabilityRequest;
import com.hotel.api.search.service.HotelRoomAvailabilityService;
import com.hotel.api.search.util.APIConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", consumes = APIConstants.MEDIATYPE_JSON)
public class HotelRoomAvailabilityController {
    @Autowired
    HotelRoomAvailabilityService hotelRoomAvailabilityService;

    @PostMapping(value = "/roomAvailability")
    public String getHotelRoomAvailability(@RequestBody HotelRoomAvailabilityRequest request){
        return hotelRoomAvailabilityService.getRoomAvailabilityService(request);

    }

}
