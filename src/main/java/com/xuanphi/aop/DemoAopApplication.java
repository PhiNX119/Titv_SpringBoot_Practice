package com.xuanphi.aop;

import com.xuanphi.aop.service.CalculatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CalculatorService calculatorService) {
        return runner -> {
            double resultAdd = calculatorService.add(5, 10);
            double resultDivide = calculatorService.divide(5, 0);
        };
    }

}
