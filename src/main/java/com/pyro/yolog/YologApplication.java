package com.pyro.yolog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YologApplication {

    public static void main(String[] args) {
        SpringApplication.run(YologApplication.class, args);
    }

}
