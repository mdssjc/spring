package org.springframework.samples.petclinic.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Marcelo dos Santos
 */
@Profile("base-test")
@Configuration
public class YannyConfig {

    @Bean
    YannyWordProducer laurelWordProducer() {
        return new YannyWordProducer();
    }
}
