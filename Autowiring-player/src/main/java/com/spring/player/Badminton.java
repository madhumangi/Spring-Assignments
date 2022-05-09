package com.spring.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class Badminton implements ISports{

    @Override
    public List<String> showPlayers() {
        return Arrays.asList(
                new String("Zen"),
                new String("Rey"),
                new String("Sid"),
                new String("Ali"),
                new String("Sam")
        );
    }
}
