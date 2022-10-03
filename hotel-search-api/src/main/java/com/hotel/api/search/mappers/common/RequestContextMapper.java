package com.hotel.api.search.mappers.common;

import com.hotel.api.search.model.SupplierCredential;
import com.hotel.service.common.Context;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.hotel.service.util.ProtoBufUtil.safeSetProtoField;

@Component
public class RequestContextMapper {
    private final String url;

    private final SupplierCredential supplierCredential;

    public RequestContextMapper(@Value("${supplier.endPoint.url}") String url, SupplierCredential supplierCredential) {
        this.url = url;
        this.supplierCredential = supplierCredential;
    }

    public Context map(){
        Context.Builder contextBuilder = Context.newBuilder();
        safeSetProtoField(contextBuilder::setSupplierUrl, url);
        safeSetProtoField(contextBuilder::setSupplierRequestorId, supplierCredential.getRequestorId());
        safeSetProtoField(contextBuilder::setSupplierCredential, supplierCredential.getPassword());

        return contextBuilder.build();

    }


}
