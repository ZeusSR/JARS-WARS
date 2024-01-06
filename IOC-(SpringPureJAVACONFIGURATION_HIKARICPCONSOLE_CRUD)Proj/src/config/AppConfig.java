package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("in") // Scan for components in the 'in' package
@Import(PersistenceConfig.class) // Import the persistence configuration
public class AppConfig {
}