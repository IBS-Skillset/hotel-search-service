package com.hotel.api.search.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.api.search.HotelSearchApiApplication;
import com.hotel.api.search.model.DescriptionRequest;
import com.hotel.api.search.service.HotelDescriptionService;
import com.hotel.api.search.util.APIConstants;
import com.hotel.service.description.HotelDescriptionResponse;
import org.junit.jupiter.api.Test;
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
@Import(HotelDescriptionController.class)
class HotelDescriptionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelDescriptionService hotelDescriptionService;

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
        mockMvc.perform(post("/api/description").contentType(APIConstants.MEDIATYPE_JSON)
                .content(objectMapper.writeValueAsString(descriptionRequest))).andExpect(status().isOk());
    }
}