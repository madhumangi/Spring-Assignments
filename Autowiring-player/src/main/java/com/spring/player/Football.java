package com.spring.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class Football implements ISports{


    @Override
    public List<String> showPlayers() {
        return Arrays.asList(
                new String("Aditya"),
                new String("Aayush"),
                new String("Ayan"),
                new String("Anirudh"),
                new String("Arjun")
        );
    }
}
