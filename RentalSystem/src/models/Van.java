package models;

public class Van extends Vehicle {
	private int driverExperience;
	private int dailyCost;

	public Van(String brand, String model, double value, int driverExperience) {
		super(brand, model, value);
		this.driverExperience = driverExperience;
	}

	public int getDriverExperience() {
		return driverExperience;
	}

	public int getDailyCost() {
		return dailyCost;
	}

	@Override
	public double calculateRentalCost(int reservedDays, int actualDays) {
		dailyCost = 50;
		if (reservedDays > 7) {
			dailyCost = 40;
		}

		double costActualDays = actualDays * dailyCost;
		double costRemainingDays = (reservedDays - actualDays) * (dailyCost / 2);

		return costActualDays + costRemainingDays;
	}

	@Override
	public double calculateInsuranceCost(int actualDays) {
		double insuranceCost = 0.0003 * getValue();
		
		if(driverExperience >=5) {// 15% discount 
			insuranceCost *= 0.85;
		}
		return insuranceCost * actualDays;
	}

	
}
