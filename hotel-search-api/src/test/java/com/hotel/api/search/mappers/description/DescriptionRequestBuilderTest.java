package com.hotel.api.search.mappers.description;
import com.hotel.api.search.mappers.common.RequestContextMapper;
import com.hotel.api.search.model.DescriptionRequest;
import com.hotel.service.common.Context;
import com.hotel.service.description.HotelDescriptionRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DescriptionRequestBuilderTest {

    @Mock
    private RequestContextMapper requestContextMapper;
    @InjectMocks
    private DescriptionRequestBuilder descriptionRequestBuilder;

    @Test
    public void map() {
        DescriptionRequest descriptionRequest=new DescriptionRequest();
        descriptionRequest.setLanguageCode("EN");
        descriptionRequest.setHotelCode("COMPOSTELLE");
        descriptionRequest.setCheckInDate("10-11-2022");
        descriptionRequest.setCheckOutDate("12-11-2022");
        descriptionRequest.setCountryCode("PAR");
        descriptionRequest.setCurrencyCode("");
        Context context = Context.newBuilder().build();
        when(requestContextMapper.map()).thenReturn(context);
        HotelDescriptionRequest hotelDescriptionRequest=descriptionRequestBuilder.map(descriptionRequest);
        assertThat(hotelDescriptionRequest.getStartDate()).isEqualTo("10-11-2022");
        assertThat(hotelDescriptionRequest.getEndDate()).isEqualTo("12-11-2022");
        assertThat(hotelDescriptionRequest.getLanguageCode()).isEqualTo("EN");
        assertThat(hotelDescriptionRequest.getHotelCode()).isEqualTo("COMPOSTELLE");
        assertThat(hotelDescriptionRequest.getCountryOfResidence()).isEqualTo("PAR");
        assertThat(hotelDescriptionRequest.getCurrencyCode()).isEqualTo("");
    }
    }
