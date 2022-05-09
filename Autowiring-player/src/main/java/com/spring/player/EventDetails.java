package com.spring.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EventDetails {
    @Autowired
    @Qualifier("cricket")
    ISports csports;
    @Autowired
    @Qualifier("football")
    ISports fsports;
    @Autowired
    @Qualifier("badminton")
    ISports bsports;
    public List<String> printEvent() {
        System.out.println("Printing Sports:");
        //List<String> players = csports.showPlayers();
       //List<String> players = fsports.showPlayers();
        List<String> players = bsports.showPlayers();
        return players;
    }
}
