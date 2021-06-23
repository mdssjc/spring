package org.springframework.samples.petclinic.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Marcelo dos Santos
 */
@Configuration
public class YannyConfig {

    @Bean
    YannyWordProducer laurelWordProducer() {
        return new YannyWordProducer();
    }
}
