package com.OO.Lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.OO.Lab.bdd.Car;
import com.OO.Lab.services.CarServiceImpl;

@SpringBootApplication
@Controller
public class LabApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CarServiceImpl carService) {
        return (args) -> {
            carService.addCar(new Car("0", "Ferrari", 100));
            carService.addCar(new Car("1", "Porsche", 150));
            carService.addCar(new Car("2", "BMW", 200));
            carService.addCar(new Car("3", "Audi", 20));
        };
    }
;


/* 
    @GetMapping("/")
    public String hello() {
        return "redirect:/cars";
    }
 */
}
