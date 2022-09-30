package com.hotel.api.search.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.protobuf.util.JsonFormat;
import com.hotel.service.description.HotelDescriptionResponse;

import java.io.IOException;

public class HotelDescriptionResponseAdapter extends TypeAdapter<HotelDescriptionResponse> {
    @Override
    public void write(JsonWriter jsonWriter, HotelDescriptionResponse hotelDescriptionResponse) throws IOException {
        jsonWriter.jsonValue(JsonFormat.printer().print(hotelDescriptionResponse));

    }

    @Override
    public HotelDescriptionResponse read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
