package com.eazybytes.config;

import com.eazybytes.beans.Person;
import com.eazybytes.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration

@ComponentScan(basePackages = {"com.eazybytes.implementation", "com.eazybytes.services"})
@ComponentScan(basePackageClasses = {com.eazybytes.beans.Vehicle.class, com.eazybytes.beans.Person.class})
public class ProjectConfig {

}
