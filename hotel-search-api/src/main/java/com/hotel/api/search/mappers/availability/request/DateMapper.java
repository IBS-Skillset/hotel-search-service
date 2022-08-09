package com.hotel.api.search.mappers.availability.request;

import com.hotel.api.search.util.APIUtils;
import com.hotel.service.common.LocalDate;

import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;
import static java.util.Objects.nonNull;


@Component
public class DateMapper {

    public LocalDate map(String date){
        LocalDate.Builder localdateBuilder = LocalDate.newBuilder();
        if(nonNull(date)) {
            java.time.LocalDate localDate = APIUtils.stringToLocalDate(date);
            safeSetProtoField(localdateBuilder::setDay,localDate.getDayOfMonth());
            safeSetProtoField(localdateBuilder::setMonth,localDate.getMonthValue());
            safeSetProtoField(localdateBuilder::setYear,localDate.getYear());
        }
        return localdateBuilder.build();

    }
}
