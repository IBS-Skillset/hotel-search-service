package com.hotel.api.search.model;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class DescriptionRequest {
    private String languageCode;
    private String hotelCode;
    private String checkInDate;
    private String checkOutDate;
    private String countryCode;
    private String currencyCode;
}
