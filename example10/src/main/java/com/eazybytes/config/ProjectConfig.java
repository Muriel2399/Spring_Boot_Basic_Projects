package com.eazybytes.config;

import com.eazybytes.beans.Person;
import com.eazybytes.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages ="com.eazybytes.beans")
public class ProjectConfig {
    @Bean
    Vehicle vehicle1() {
        //System.out.println("In vehicle1");
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }

    @Bean
    Vehicle vehicle2() {
        //System.out.println("In vehicle2");
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }

    @Bean
    Vehicle vehicle3() {
        //System.out.println("In vehicle3");
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }
}
