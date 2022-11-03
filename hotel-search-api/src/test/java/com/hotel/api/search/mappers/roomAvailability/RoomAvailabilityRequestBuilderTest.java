package com.hotel.api.search.mappers.roomAvailability;

import com.hotel.api.search.mappers.common.RequestContextMapper;
import com.hotel.api.search.model.HotelRoomAvailabilityRequest;
import com.hotel.service.common.Context;
import com.hotel.service.roomavailability.RoomAvailabilityRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;


@ExtendWith(MockitoExtension.class)
public class RoomAvailabilityRequestBuilderTest {

    @Mock
    private RequestContextMapper requestContextMapper;

    @InjectMocks
    private RoomAvailabilityRequestBuilder roomAvailabilityRequestBuilder;

    @Test
    public void map() {
        HotelRoomAvailabilityRequest hotelRoomAvailabilityRequest = requestMap();
        Context context = Context.newBuilder().build();
        when(requestContextMapper.map()).thenReturn(context);
        RoomAvailabilityRequest roomAvailabilityRequest = roomAvailabilityRequestBuilder.map(hotelRoomAvailabilityRequest);

        assertThat(roomAvailabilityRequest.getHotelCode()).isEqualTo("354422");
        assertThat(roomAvailabilityRequest.getStartDate()).isEqualTo("2022-10-18");
        assertThat(roomAvailabilityRequest.getEndDate()).isEqualTo("2022-10-25");
        assertThat(roomAvailabilityRequest.getLanguageCode()).isEqualTo("FRE");
        assertThat(roomAvailabilityRequest.getHomeCountryCode()).isEqualTo("FR");
        assertThat(roomAvailabilityRequest.getRoomCount()).isEqualTo(2);
        assertThat(roomAvailabilityRequest.getNightsNeeded()).isEqualTo(2);
        assertThat(roomAvailabilityRequest.getOccupancy()).isEqualTo(1);
        verify(requestContextMapper, atLeast(1)).map();
    }

    public HotelRoomAvailabilityRequest requestMap() {
        HotelRoomAvailabilityRequest hotelRoomAvailabilityRequest = new HotelRoomAvailabilityRequest();
        hotelRoomAvailabilityRequest.setHotelCode("354422");
        hotelRoomAvailabilityRequest.setRoomCount(2);
        hotelRoomAvailabilityRequest.setCheckInDate("2022-10-18");
        hotelRoomAvailabilityRequest.setCheckOutDate("2022-10-25");
        hotelRoomAvailabilityRequest.setCurrencyCode("EUR");
        hotelRoomAvailabilityRequest.setLanguageCode("FRE");
        hotelRoomAvailabilityRequest.setOccupancy(1);
        hotelRoomAvailabilityRequest.setCountryCode("FR");
        hotelRoomAvailabilityRequest.setNoOfNights(2);
        return hotelRoomAvailabilityRequest;
    }

}