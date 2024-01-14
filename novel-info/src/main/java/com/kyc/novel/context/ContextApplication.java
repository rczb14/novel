package com.kyc.novel.context;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
@MapperScan("com.kyc.novel.context.mapper")
public class ContextApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContextApplication.class);
    }
}
