package com.hotel.api.search.service;
import com.hotel.api.search.mappers.description.DescriptionRequestBuilder;
import com.hotel.api.search.model.DescriptionRequest;
import com.hotel.service.description.HotelDescriptionRequest;
import com.hotel.service.description.HotelDescriptionServiceGrpc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class HotelDescriptionServiceTest {
    @Mock
    private HotelDescriptionServiceGrpc.HotelDescriptionServiceBlockingStub hotelDescriptionServiceBlockingStub;

    @Mock
    private DescriptionRequestBuilder requestBuilder;

    @InjectMocks
    private HotelDescriptionService hotelDescriptionService;

    @Test
    public void service() {
        DescriptionRequest descriptionRequest=new DescriptionRequest();
        descriptionRequest.setLanguageCode("EN");
        descriptionRequest.setHotelCode("COMPOSTELLE");
        descriptionRequest.setCheckInDate("10/11/2022");
        descriptionRequest.setCheckOutDate("12/11/2022");
        descriptionRequest.setCountryCode("PAR");
        descriptionRequest.setCurrencyCode("EUR");
        HotelDescriptionRequest hotelDescriptionRequest=HotelDescriptionRequest.newBuilder().build();
        when(requestBuilder.map(descriptionRequest)).thenReturn(hotelDescriptionRequest);
        when(hotelDescriptionServiceBlockingStub.getHotelDescription(any())).thenReturn(any());
        String response = hotelDescriptionService.service(descriptionRequest);
        assertThat(response).isNotNull();
    }
}