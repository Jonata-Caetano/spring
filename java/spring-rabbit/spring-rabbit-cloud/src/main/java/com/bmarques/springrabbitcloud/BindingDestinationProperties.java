package com.bmarques.springrabbitcloud;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("binding-destination")
public class BindingDestinationProperties {
    private String employeeProducer;
}
