package models;

public class Car extends Vehicle {
	private int safetyRating;
	private int dailyCost;
	
	public Car(String brand, String model, double value, int safetyRating) {
		super(brand, model, value);
		this.safetyRating = safetyRating;
	}

	public int getSafetyRating() {
		return safetyRating;
	}

	public int getDailyCost() {
		return dailyCost;
	}
	
	public double calculateRentalCost(int reservedDays, int actualDays) {
		dailyCost = 20;
		if (reservedDays > 7) {
			dailyCost = 15;
		}
		
		double costForActualDays = actualDays * dailyCost;
		double costForRemainingDays = (reservedDays - actualDays) * (dailyCost/2);
		
		return costForActualDays + costForRemainingDays;
	}

	public double calculateInsuranceCost(int actualDays) {
		double insuranceCost = 0.0001 * getValue();
		
		if (safetyRating >= 4) {// 10% discount
			insuranceCost *= 0.9;
		}
		return insuranceCost * actualDays;
	}
}
