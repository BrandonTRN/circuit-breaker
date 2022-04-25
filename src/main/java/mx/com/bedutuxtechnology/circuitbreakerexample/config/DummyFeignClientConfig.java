package mx.com.bedutuxtechnology.circuitbreakerexample.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;

public class DummyFeignClientConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    
}
