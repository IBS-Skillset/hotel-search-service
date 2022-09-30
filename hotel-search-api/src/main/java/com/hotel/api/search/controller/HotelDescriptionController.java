package com.hotel.api.search.controller;

import com.hotel.api.search.model.DescriptionRequest;
import com.hotel.api.search.service.HotelDescriptionService;
import com.hotel.api.search.util.APIConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", consumes = APIConstants.MEDIATYPE_JSON)
public class HotelDescriptionController {

    @Autowired
    private HotelDescriptionService hotelDescriptionService;

    @PostMapping(value = "/description")
    public String getDescriptionResponse(@RequestBody DescriptionRequest request) {
        return hotelDescriptionService.service(request);
    }
}
