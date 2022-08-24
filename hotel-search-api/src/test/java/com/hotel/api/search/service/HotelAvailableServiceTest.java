package com.hotel.api.search.service;

import com.hotel.api.search.mappers.availability.request.AvailabilityRequestBuilder;
import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.service.availability.HotelAvailabilityRequest;
import com.hotel.service.availability.HotelServiceGrpc;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HotelAvailableServiceTest {
    @Mock
    private  HotelServiceGrpc.HotelServiceBlockingStub blockingStub;

    @InjectMocks
    private HotelAvailableService hotelAvailableService;

    @Mock
    private AvailabilityRequestBuilder availabilityRequestBuilder;

    @Test
    public void serviceTest() {
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