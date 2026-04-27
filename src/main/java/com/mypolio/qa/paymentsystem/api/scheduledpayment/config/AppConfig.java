package com.mypolio.qa.paymentsystem.api.scheduledpayment.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "cl.QA-Engine-Pro")
@EntityScan(basePackages = { "cl.QA-Engine-Pro" })
public class AppConfig {

}

