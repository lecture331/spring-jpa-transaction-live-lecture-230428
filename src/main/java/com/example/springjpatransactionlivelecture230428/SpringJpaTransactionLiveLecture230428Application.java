package com.example.springjpatransactionlivelecture230428;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringJpaTransactionLiveLecture230428Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaTransactionLiveLecture230428Application.class, args);
    }

}
