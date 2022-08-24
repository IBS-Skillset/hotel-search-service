package com.hotel.api.search.mappers.availability.request;

import com.hotel.api.search.model.HotelAvailableRequest;
import com.hotel.service.availability.HotelAvailabilityRequest;
import com.hotel.service.common.Context;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AvailabilityRequestBuilderTest {

    @InjectMocks
    private AvailabilityRequestBuilder availabilityRequestBuilder;
    @Mock
    private RequestContextMapper requestContextMapper;

    @Test
    public void map() {
        HotelAvailableRequest hotelAvailableRequest = new HotelAvailableRequest();
        hotelAvailableRequest.setLatitude(47.03);
        hotelAvailableRequest.setLongitude(4.76);
        hotelAvailableRequest.setCheckInDate("20220912");
        hotelAvailableRequest.setCheckOutDate("20220913");
        Context context = Context.newBuilder().build();
        when(requestContextMapper.map()).thenReturn(context);
        HotelAvailabilityRequest hotelAvailabilityRequest = availabilityRequestBuilder.map(hotelAvailableRequest);
        assertThat(hotelAvailabilityRequest.getStartDate()).isEqualTo("2022-09-12");
        assertThat(hotelAvailabilityRequest.getEndDate()).isEqualTo("2022-09-13");
        assertThat(hotelAvailabilityRequest.getLatitude()).isEqualTo(47.03);
        assertThat(hotelAvailabilityRequest.getLongitude()).isEqualTo(4.76);
    }
}