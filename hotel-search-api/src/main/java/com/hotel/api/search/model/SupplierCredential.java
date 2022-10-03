package com.hotel.api.search.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("supplier")
public class SupplierCredential {

    private String requestorId;
    private String password;

}
