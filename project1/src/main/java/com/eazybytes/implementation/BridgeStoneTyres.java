package com.eazybytes.implementation;

import com.eazybytes.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class BridgeStoneTyres implements Tyres {
    @Override
    public String rotate() {
        return "Vehicle is moving on BridgeStone Tyres";
    }
}
