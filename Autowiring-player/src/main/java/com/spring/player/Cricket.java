package com.spring.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Cricket implements ISports{

    @Override
    public List<String> showPlayers() {
        return Arrays.asList(
                new String("Chintu"),
                new String("Bantu"),
                new String("Monty"),
                new String("Munna"),
                new String("Pintu")
        );
    }
}
