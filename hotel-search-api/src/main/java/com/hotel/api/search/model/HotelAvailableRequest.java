package com.hotel.api.search.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class HotelAvailableRequest {
    private double latitude;
    private double longitude;
    private String checkInDate;
    private String checkOutDate;
}
