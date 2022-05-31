package com.digitalinnovation.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("sprig.datasouce")
public class BDConfig {

    private String driverClassName;
    private String url;
    private String username;

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    @Profile("dev")
    @Bean
    public String testDataBaseConnection(){
        System.out.println("DB connection for DEV-H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to H2_TEST - Test Instance";
    }

    @Profile("prod")
    @Bean
    public String productionDataBaseConnection(){
        System.out.println("DB connection for PRODUCTION - MySQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to MYSQL_PROD - Production Instance";
    }
}
