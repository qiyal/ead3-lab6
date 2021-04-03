package spring.lab6.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@Configuration
@ComponentScan("spring.lab6.demo")
@PropertySource("/application.properties")
@EnableJpaRepositories(basePackages = "spring.lab6.demo")
public class SpringAppConfig {

    @Bean
    public Scanner getScannerBean() {
        return new Scanner(System.in);
    }
}
