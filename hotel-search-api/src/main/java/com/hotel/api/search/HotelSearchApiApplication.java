package com.hotel.api.search;

import com.hotel.api.search.model.SupplierCredential;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigurationProperties(SupplierCredential.class)
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class HotelSearchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSearchApiApplication.class, args);
	}

}
