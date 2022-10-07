package com.hotel.api.search.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.protobuf.util.JsonFormat;
import com.hotel.service.roomavailability.RoomAvailabilityResponse;

import java.io.IOException;

public class HotelRoomAvailabilityResponseAdapter extends TypeAdapter<RoomAvailabilityResponse> {

    @Override
    public void write(JsonWriter jsonWriter, RoomAvailabilityResponse roomAvailabilityResponse) throws IOException {
        jsonWriter.jsonValue(JsonFormat.printer().print(roomAvailabilityResponse));

    }

    @Override
    public RoomAvailabilityResponse read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
