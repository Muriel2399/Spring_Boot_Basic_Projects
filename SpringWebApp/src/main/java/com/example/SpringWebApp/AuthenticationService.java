package com.example.SpringWebApp;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String name, String password) {
        System.out.println("Authenticating user "+name);
        System.out.println("Authenticating password "+password);
        if(name.equals("Muriel") && password.equals("mew@23")) {
            return true;
        }
        return false;
    }
}
