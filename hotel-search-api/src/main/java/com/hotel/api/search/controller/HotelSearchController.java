package com.hotel.api.search.controller;


import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.api.search.service.HotelAvailableService;
import com.hotel.api.search.util.APIConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", consumes = APIConstants.MEDIATYPE_JSON)
public class HotelSearchController {

    @Autowired
    private HotelAvailableService hotelAvailableService;

    @PostMapping(value = "/availability")
    public String getAvailableResponse(@RequestBody HotelAvailableRequest request) {
        return hotelAvailableService.service(request);

    }
}
