package com.revivable.hydrogen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.revivable.hydrogen.dao")
public class HydrogenApplication {

    public static void main(String[] args) {
        SpringApplication.run(HydrogenApplication.class, args);
    }

}
