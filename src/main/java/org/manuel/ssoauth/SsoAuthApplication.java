package org.manuel.ssoauth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SsoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoAuthApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(Environment environment) {
        return args -> System.out.println("http://localhost:" + environment.getProperty("server.port"));
    }
}
