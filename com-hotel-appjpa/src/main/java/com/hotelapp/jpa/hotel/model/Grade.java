package com.hotelapp.jpa.hotel.model;

public enum Grade {
    THREE("3 STAR"),
    FOUR("4 STAR"),
    FIVE("5 STAR");

    public String grade;
    Grade(String grade) {
        this.grade=grade;

    }
}
