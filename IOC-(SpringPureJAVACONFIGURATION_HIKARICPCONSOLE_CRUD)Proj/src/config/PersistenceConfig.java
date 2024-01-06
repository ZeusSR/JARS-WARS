package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("in/neuralnet/properties/application.properties") // Load properties
public class PersistenceConfig {

	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.user}")
	private String username;

	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.url}")
	private String url;

    @Bean
    public DriverManagerDataSource postgresqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver); //"${jdbc.driver}"
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    

    @Bean  
    public HikariDataSource hikariDataSource()
 
    {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDataSource(postgresqlDataSource()); // Use PostgreSQL DataSource as parent
        dataSource.setMinimumIdle(10);
        dataSource.setMaximumPoolSize(20);
        dataSource.setConnectionTimeout(2000);
//        dataSource.setJdbcUrl(url);
        return dataSource;
    }
	
}
