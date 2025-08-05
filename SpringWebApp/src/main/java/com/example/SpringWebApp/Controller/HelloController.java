package com.example.SpringWebApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "What are you learning today?";
    }

    @RequestMapping("say-hello-html")
    public String sayHelloHtml(){
        return "index.html";
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJSP(){
        return "Home";
    }
}
