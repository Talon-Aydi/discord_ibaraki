package discord.ibaraki.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.driver-class-name:org.postgresql.Driver}")
    private String driver;
    @Value("${spring.datasource.url:}")
    private String url;
    @Value("${spring.datasource.username:}")
    private String user;
    @Value("${spring.datasource.password:}")
    private String password;

    @Bean public DataSource source()
    {
        DataSourceBuilder<?> dSB = DataSourceBuilder.create();
        dSB.driverClassName(driver);
        dSB.url(url);
        dSB.username(user);
        dSB.password(password);

        return dSB.build();
    }
}
