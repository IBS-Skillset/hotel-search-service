package com.hotel.api.search.mappers.availability.request;

import com.hotel.service.common.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RequestContextMapperTest {

    private RequestContextMapper requestContextMapper;

    @BeforeEach
    public void setUp() {
        requestContextMapper = new RequestContextMapper("https://traveldoo.koedia.com", "DJANTLmP90QE", "aWVhLc6g");
    }

    @Test
    public void map() {
        Context context = requestContextMapper.map();
        assertThat(context).isNotNull();
        assertThat(context.getSupplierUrl()).isEqualTo("https://traveldoo.koedia.com");
        assertThat(context.getSupplierRequestorId()).isEqualTo("DJANTLmP90QE");
        assertThat(context.getSupplierCredential()).isEqualTo("aWVhLc6g");
    }
}