package cl.prodigio.sfa.api.scheduledpayment.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "cl.prodigio")
@EntityScan(basePackages = { "cl.prodigio" })
public class AppConfig {

}
