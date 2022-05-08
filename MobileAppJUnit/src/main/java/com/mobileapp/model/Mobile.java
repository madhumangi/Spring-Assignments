package com.mobileapp.model;

public class Mobile {
	int mobileId;
	String model;
	String brand;
	float price;
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(int mobileId, String model, String brand, float price) {
		super();
		this.mobileId = mobileId;
		this.model = model;
		this.brand = brand;
		this.price = price;
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "\nMobile [mobileId=" + mobileId + ", model=" + model + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
}
