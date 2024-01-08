package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("in/neuralnet/properties/application.properties") // Load properties
public class PersistenceConfig {

	@Autowired
	private Environment environment;

    @Bean("dataSource")
    public DataSource getdatasource() {
    	
    	HikariDataSource dataSource = new HikariDataSource();
    	
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver")); 
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setMinimumIdle(10);
        dataSource.setMaximumPoolSize(20);
        dataSource.setConnectionTimeout(2000);
        
        return dataSource;
    }

    
//
//    @Bean  
//    public HikariDataSource hikariDataSource()
// 
//    {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDataSource(postgresqlDataSource()); // Use PostgreSQL DataSource as parent
//        dataSource.setMinimumIdle(10);
//        dataSource.setMaximumPoolSize(20);
//        dataSource.setConnectionTimeout(2000);
////        dataSource.setJdbcUrl(url);
//        return dataSource;
//    }
	
}
