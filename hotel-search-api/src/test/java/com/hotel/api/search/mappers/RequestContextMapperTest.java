package com.hotel.api.search.mappers;

import com.hotel.api.search.mappers.common.RequestContextMapper;
import com.hotel.api.search.model.SupplierCredential;
import com.hotel.service.common.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RequestContextMapperTest {

    private RequestContextMapper requestContextMapper;

    @BeforeEach
    public void setUp() {
        SupplierCredential supplierCredential = new SupplierCredential();
        supplierCredential.setRequestorId("XXXXXX");
        supplierCredential.setPassword("XXXXXX");
        requestContextMapper = new RequestContextMapper("https://traveldoo.koedia.com",supplierCredential);
    }

    @Test
    public void map() {
        Context context = requestContextMapper.map();
        assertThat(context).isNotNull();
        assertThat(context.getSupplierUrl()).isEqualTo("https://traveldoo.koedia.com");
        assertThat(context.getSupplierRequestorId()).isEqualTo("XXXXXX");
        assertThat(context.getSupplierCredential()).isEqualTo("XXXXXX");

    }
}
