package com.spring.player;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlayerMain {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("com.spring");
        EventDetails eventDetails=context.getBean("eventDetails",EventDetails.class);
        //System.out.println("eventDetails = " + eventDetails);
        for(String player:eventDetails.printEvent())
            System.out.println(player);
        //System.out.println("eventDetails = " + eventDetails);
    }

}
