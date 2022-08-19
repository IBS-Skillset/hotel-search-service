package com.hotel.api.search.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.protobuf.util.JsonFormat;
import com.hotel.service.availability.HotelAvailabilityResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HotelAvailabilityResponseAdapter extends TypeAdapter<HotelAvailabilityResponse> {

    @Override
    public void write(JsonWriter jsonWriter, HotelAvailabilityResponse hotelAvailabilityResponse) throws IOException {
             jsonWriter.jsonValue(JsonFormat.printer().print(hotelAvailabilityResponse));
    }

    @Override
    public HotelAvailabilityResponse read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
