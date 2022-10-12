package com.hotel.api.search.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class HotelRoomAvailabilityRequest {
    private String languageCode;
    private String hotelCode;
    private String checkInDate;
    private String checkOutDate;
    private String countryCode;
    private String currencyCode;
    private int roomCount;
    private int noOfNights;
    private int occupancy;

}
