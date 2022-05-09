package com.furnapp.model;

public enum Material {
    TWOOD(1,"TEAK WOOD"),
    MWOOD(2,"Mango Wood"),
    PLASTIC(3,"Plastic"),
    SWOORD(4,"Sheesham Wood"),
    FABRIC(5,"Soft Fabric"),
    LEATHER(6,"Leatherite");

    public int grade;
    public String type;
    Material(int grade,String type)
    {
        this.grade=grade;
        this.type=type;
    }

}
