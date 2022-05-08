package com.hotelapp.model;

public enum Grade {
	ONE("1 STAR"),TWO("2 STAR"),THREE("3 STAR"),FOUR("4 STAR"),FIVE("5 STAR");

	public String grade;
	Grade(String ngrade) {
		this.grade = ngrade;
	}
	
}
