package models;

public abstract class Vehicle {
private String brand;
private String model;
private double value;
private int dailyCost;

public Vehicle(String brand, String model, double value) {// Constructor
	super();
	this.brand = brand;
	this.model = model;
	this.value = value;
}
//Getters,no setters because out data is not going to be changed
public String getBrand() {
	return brand;
}

public String getModel() {
	return model;
}

public double getValue() {
	return value;
}
public int getDailyCost() {
	return dailyCost;
}

public abstract double calculateRentalCost(int reservedDays, int actualDays);// Method calculating total rental cost
public abstract double calculateInsuranceCost(int actualDays);// Method calculating total insurance cost
}
