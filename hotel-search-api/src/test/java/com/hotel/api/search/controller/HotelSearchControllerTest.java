package com.hotel.api.search.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.api.search.HotelSearchApiApplication;
import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.api.search.service.HotelAvailabilityService;
import com.hotel.api.search.util.APIConstants;
import com.hotel.service.availability.HotelAvailabilityResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelSearchApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Import(HotelSearchController.class)
public class HotelSearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelAvailabilityService hotelAvailableService;

    @Test
    public void getAvailableResponseTest() throws Exception {
        HotelAvailableRequest hotelAvailableRequest = new HotelAvailableRequest();
        hotelAvailableRequest.setLatitude(47.03);
        hotelAvailableRequest.setLongitude(4.76);
        hotelAvailableRequest.setCheckInDate("12/09/2022");
        hotelAvailableRequest.setCheckOutDate("13/09/2022");
        HotelAvailabilityResponse hotelAvailabilityResponse = HotelAvailabilityResponse.newBuilder().build();
        when(hotelAvailableService.service(hotelAvailableRequest)).thenReturn(String.valueOf(hotelAvailabilityResponse));

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/availability")
                        .contentType(APIConstants.MEDIATYPE_JSON).content(objectMapper.writeValueAsString(hotelAvailableRequest)))
                .andExpect(status().isOk());
    }
}