package guru.sfg.brewery.inventoryfailover.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Marcelo dos Santos
 */
@EnableDiscoveryClient
@Profile("local-discovery")
@Configuration
public class LocalDiscovery {
}
