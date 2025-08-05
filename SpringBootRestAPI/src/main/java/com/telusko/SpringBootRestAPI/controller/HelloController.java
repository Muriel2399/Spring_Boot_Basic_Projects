package com.telusko.SpringBootRestAPI.controller;

import com.telusko.SpringBootRestAPI.model.HelloBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {
    // /hello-world => "Hello World"

    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }


    @RequestMapping("/hello-bean")
    public HelloBean helloBean() {
        return new HelloBean("Hello World");
    }

    //Path Variable or Path Params
    // /user/Ranga/todos/1

    @RequestMapping("/hello-path-param/{name}")
    public HelloBean helloPathParam(@PathVariable String name) {
        return new HelloBean("Hello World, " + name);
    }

    @RequestMapping("/hello-world-path-param/{name}/message/{message}")
    public HelloBean helloMultiplePathParam
            (@PathVariable String name,
             @PathVariable String message) {
        return new HelloBean("Hello World " + name + "," + message);
    }

}