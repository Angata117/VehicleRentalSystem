package models;

public class Motorcycle extends Vehicle {
	private int riderAge;
	private int dailyCost;
	public Motorcycle(String brand, String model, double value, int riderAge) {
		super(brand, model, value);
		this.riderAge = riderAge;
		
	}

	public int getRiderAge() {
		return riderAge;
	}

	public int getDailyCost() {
		return dailyCost;
	}
	@Override
	public double calculateRentalCost(int reservedDays, int actualDays) {
		dailyCost = 15;
		if (reservedDays > 7) {
			dailyCost = 10;
		}
		
		double costActualDays = actualDays * dailyCost;
		double costRemainingDays = (reservedDays - actualDays) * (dailyCost/2);
		
		return costActualDays + costRemainingDays;		
	}

	@Override
	public double calculateInsuranceCost(int actualDays) {
		double insuranceCost = 0.0002 * getValue();
		
		if (riderAge < 25) {//20% increased insurance
			insuranceCost *= 1.2;
		}
		System.out.println(insuranceCost*actualDays);
		return insuranceCost * actualDays;
	}
	
}
