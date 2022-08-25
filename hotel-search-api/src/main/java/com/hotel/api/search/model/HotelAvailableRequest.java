package com.hotel.api.search.model;

import lombok.*;


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
