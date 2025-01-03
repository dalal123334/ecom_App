package org.sid.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ConfigurationProperties(prefix = "customer.params")

public class  CustomerConfigParams {
    private int x;
    private int y;
}
