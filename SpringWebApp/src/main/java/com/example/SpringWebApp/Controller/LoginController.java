package com.example.SpringWebApp.Controller;

import com.example.SpringWebApp.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
    @Autowired
    private AuthenticationService as;
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "login", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public String gotologin() {
//        model.addAttribute("name", name);
//        System.out.println("RequestParam is "+name);
//        logger.debug("debug param is "+name);
//        logger.info("info param is "+name);
//        logger.warn("warn param is "+name);
        return "Login";
    }

    @RequestMapping(value = "login", method = org.springframework.web.bind.annotation.RequestMethod.POST)
    public String gotoWelcome(@RequestParam("name") String n, ModelMap model, @RequestParam("password") String p) {
        boolean result = as.authenticate(n, p);
        if (result) {
            model.addAttribute("name", n);
           // model.addAttribute("password", p);
            return "Welcome";
        }
        model.addAttribute("errMessage", "Invalid Credentials. Please try again.");
        return "Login";
    }
}