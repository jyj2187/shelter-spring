package kr.co.llems.shelterspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ShelterSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelterSpringApplication.class, args);
    }

}
