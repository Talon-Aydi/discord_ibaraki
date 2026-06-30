package discord.ibaraki.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${datasource.driver:org.postgresql.Driver}")
    private String driver;
    @Value("${datasource.url:}")
    private String url;
    @Value("${datasource.user:}")
    private String user;
    @Value("${datasource.password:}")
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
