package com.hotel.api.search.mappers.common;

import com.hotel.service.common.Context;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class RequestContextMapper {
    private final String url;
    private final String requestorId;
    private final String credential;


    public RequestContextMapper(@Value("${supplier.endPoint.url}") String url,
                                @Value("${supplier.endPoint.requestorId}") String requestorId,
                                @Value("${supplier.endPoint.credential}") String credential) {
        this.url = url;
        this.requestorId = requestorId;
        this.credential = credential;
    }

    public Context map(){
        Context.Builder contextBuilder = Context.newBuilder();
        safeSetProtoField(contextBuilder::setSupplierUrl, url);
        safeSetProtoField(contextBuilder::setSupplierRequestorId, requestorId);
        safeSetProtoField(contextBuilder::setSupplierCredential, credential);

        return contextBuilder.build();

    }


}
