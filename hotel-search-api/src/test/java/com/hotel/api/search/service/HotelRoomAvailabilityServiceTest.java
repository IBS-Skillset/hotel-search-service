package com.hotel.api.search.service;

import com.hotel.api.search.mappers.roomAvailability.RoomAvailabilityRequestBuilder;
import com.hotel.api.search.mappers.roomAvailability.RoomAvailabilityRequestBuilderTest;
import com.hotel.api.search.model.HotelRoomAvailabilityRequest;
import com.hotel.service.roomavailability.HotelRoomAvailabilityServiceGrpc;
import com.hotel.service.roomavailability.RoomAvailabilityRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;


@ExtendWith(MockitoExtension.class)
public class HotelRoomAvailabilityServiceTest {

    @Mock
    HotelRoomAvailabilityServiceGrpc.HotelRoomAvailabilityServiceBlockingStub hotelRoomAvailabilityServiceBlockingStub;

    @Mock
    private RoomAvailabilityRequestBuilder roomAvailabilityRequestBuilder;

    @InjectMocks
    private HotelRoomAvailabilityService hotelRoomAvailabilityService;

    @InjectMocks
    private RoomAvailabilityRequestBuilderTest roomAvailabilityRequestBuilderTest;

    @Test
    public void getRoomAvailabilityServiceTest() {
        HotelRoomAvailabilityRequest hotelRoomAvailabilityRequest = roomAvailabilityRequestBuilderTest.requestMap();
        RoomAvailabilityRequest roomAvailabilityRequest = RoomAvailabilityRequest.newBuilder().build();
        when(roomAvailabilityRequestBuilder.map(hotelRoomAvailabilityRequest)).thenReturn(roomAvailabilityRequest);
        when(hotelRoomAvailabilityServiceBlockingStub.getRoomAvailability(any())).thenReturn(any());
        String response = hotelRoomAvailabilityService.getRoomAvailabilityService(hotelRoomAvailabilityRequest);
        assertThat(response).isNotNull();
        verify(roomAvailabilityRequestBuilder, atLeast(1)).map(hotelRoomAvailabilityRequest);
        verify(hotelRoomAvailabilityServiceBlockingStub, atLeast(1)).getRoomAvailability(any());
    }
}
