package com.eazybytes.implementation;

import com.eazybytes.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {
    public String makeSound() {
        return "Playing music from Sony Speakers";
    }
}
