package com.hotel.api.search.service;

import com.hotel.api.search.mappers.availability.request.AvailabilityRequestBuilder;
import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.service.availability.HotelAvailabilityRequest;
import com.hotel.service.availability.HotelServiceGrpc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HotelAvailableServiceTest {

    @Mock
    private HotelServiceGrpc.HotelServiceBlockingStub blockingStub;

    @Mock
    private AvailabilityRequestBuilder availabilityRequestBuilder;

    @InjectMocks
    private HotelAvailableService hotelAvailableService;


    @Test
    public void serviceTest(){
        HotelAvailableRequest hotelAvailableRequest = new HotelAvailableRequest();
        hotelAvailableRequest.setLatitude(47.03);
        hotelAvailableRequest.setLongitude(4.76);
        hotelAvailableRequest.setCheckInDate("12/09/2022");
        hotelAvailableRequest.setCheckOutDate("13/09/2022");
        HotelAvailabilityRequest hotelAvailabilityRequest = HotelAvailabilityRequest.newBuilder().build();
        when(availabilityRequestBuilder.map(hotelAvailableRequest)).thenReturn(hotelAvailabilityRequest);
        when(blockingStub.getHotelItem(any())).thenReturn(any());
        String response = hotelAvailableService.service(hotelAvailableRequest);
        assertThat(response).isNotNull();
    }




}