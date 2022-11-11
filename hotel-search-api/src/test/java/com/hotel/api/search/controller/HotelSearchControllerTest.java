package com.hotel.api.search.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.api.search.HotelSearchApiApplication;
import com.hotel.api.search.mappers.roomAvailability.RoomAvailabilityRequestBuilderTest;
import com.hotel.api.search.model.DescriptionRequest;
import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.api.search.model.HotelRoomAvailabilityRequest;
import com.hotel.api.search.service.HotelAvailabilityService;
import com.hotel.api.search.service.HotelDescriptionService;
import com.hotel.api.search.service.HotelRoomAvailabilityService;
import com.hotel.service.availability.HotelAvailabilityResponse;
import com.hotel.service.description.HotelDescriptionResponse;
import com.hotel.service.roomavailability.RoomAvailabilityResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelSearchApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Import({HotelSearchController.class})
public class HotelSearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelAvailabilityService hotelAvailableService;
    @MockBean
    private HotelDescriptionService hotelDescriptionService;
    @MockBean
    private HotelRoomAvailabilityService hotelRoomAvailabilityService;

    @InjectMocks
    private RoomAvailabilityRequestBuilderTest roomAvailabilityRequestBuilderTest;



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
                        .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(hotelAvailableRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void getDescriptionResponse() throws Exception{
        DescriptionRequest descriptionRequest=new DescriptionRequest();
        descriptionRequest.setLanguageCode("EN");
        descriptionRequest.setHotelCode("COMPOSTELLE");
        descriptionRequest.setCheckInDate("10/11/2022");
        descriptionRequest.setCheckOutDate("12/11/2022");
        descriptionRequest.setCountryCode("PAR");
        descriptionRequest.setCurrencyCode("EUR");
        HotelDescriptionResponse hotelDescriptionResponse=HotelDescriptionResponse.newBuilder().build();
        when(hotelDescriptionService.service(descriptionRequest)).thenReturn(String.valueOf(hotelDescriptionResponse));
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/description").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(descriptionRequest))).andExpect(status().isOk());
    }

    @Test
    public void getHotelRoomAvailability() throws Exception {
        HotelRoomAvailabilityRequest hotelRoomAvailabilityRequest = roomAvailabilityRequestBuilderTest.requestMap();
        RoomAvailabilityResponse roomAvailabilityResponse = RoomAvailabilityResponse.newBuilder().build();
        when(hotelRoomAvailabilityService.getRoomAvailabilityService(hotelRoomAvailabilityRequest)).thenReturn(String.valueOf(roomAvailabilityResponse));
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/roomAvailability")
                        .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(hotelRoomAvailabilityRequest)))
                .andExpect(status().isOk());
        verify(hotelRoomAvailabilityService, atLeast(1)).getRoomAvailabilityService(hotelRoomAvailabilityRequest);
    }
}