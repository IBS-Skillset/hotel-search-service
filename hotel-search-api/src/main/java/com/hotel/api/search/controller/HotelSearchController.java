package com.hotel.api.search.controller;


import com.hotel.api.search.model.DescriptionRequest;
import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.api.search.model.HotelRoomAvailabilityRequest;
import com.hotel.api.search.service.HotelAvailabilityService;
import com.hotel.api.search.service.HotelDescriptionService;
import com.hotel.api.search.service.HotelRoomAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", consumes = MediaType.APPLICATION_JSON_VALUE)
public class HotelSearchController {

    @Autowired
    private HotelAvailabilityService hotelAvailableService;
    @Autowired
    HotelRoomAvailabilityService hotelRoomAvailabilityService;
    @Autowired
    private HotelDescriptionService hotelDescriptionService;

    @PostMapping(value = "/availability")
    public String getAvailableResponse(@RequestBody HotelAvailableRequest request) {
        return hotelAvailableService.service(request);
    }

    @PostMapping(value = "/roomAvailability")
    public String getHotelRoomAvailability(@RequestBody HotelRoomAvailabilityRequest request){
        return hotelRoomAvailabilityService.getRoomAvailabilityService(request);
    }

    @PostMapping(value = "/description")
    public String getDescriptionResponse(@RequestBody DescriptionRequest request) {
        return hotelDescriptionService.service(request);
    }
}
