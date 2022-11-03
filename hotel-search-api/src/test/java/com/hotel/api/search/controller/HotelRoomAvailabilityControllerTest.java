package com.hotel.api.search.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.api.search.HotelSearchApiApplication;
import com.hotel.api.search.mappers.roomAvailability.RoomAvailabilityRequestBuilderTest;
import com.hotel.api.search.model.HotelRoomAvailabilityRequest;
import com.hotel.api.search.service.HotelRoomAvailabilityService;
import com.hotel.api.search.util.APIConstants;
import com.hotel.service.roomavailability.RoomAvailabilityResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelSearchApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Import(HotelSearchController.class)
public class HotelRoomAvailabilityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelRoomAvailabilityService hotelRoomAvailabilityService;

    @InjectMocks
    private RoomAvailabilityRequestBuilderTest roomAvailabilityRequestBuilderTest;

    @Test
    public void getHotelRoomAvailability() throws Exception {
        HotelRoomAvailabilityRequest hotelRoomAvailabilityRequest = roomAvailabilityRequestBuilderTest.requestMap();
        RoomAvailabilityResponse roomAvailabilityResponse = RoomAvailabilityResponse.newBuilder().build();
        when(hotelRoomAvailabilityService.getRoomAvailabilityService(hotelRoomAvailabilityRequest)).thenReturn(String.valueOf(roomAvailabilityResponse));
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/roomAvailability")
                .contentType(APIConstants.MEDIATYPE_JSON).content(objectMapper.writeValueAsString(hotelRoomAvailabilityRequest)))
                .andExpect(status().isOk());
        verify(hotelRoomAvailabilityService, atLeast(1)).getRoomAvailabilityService(hotelRoomAvailabilityRequest);
    }

}