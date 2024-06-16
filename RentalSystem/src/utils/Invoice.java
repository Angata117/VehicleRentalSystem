package utils;

import java.time.LocalDate;

import models.Motorcycle;
import models.Van;
import models.Vehicle;

public class Invoice {
	private String customerName;
	private Vehicle rentedVehicle;
	private int reservedRentalDays;
	private int actualRentedDays;
	private double totalRentalCost;
	private double totalInsuranceCost;
	private LocalDate reservationStart;
	private LocalDate reservationEnd;
	private LocalDate actualReturnDate;

	public Invoice(String customerName, Vehicle rentedVehicle, int reservedRentalDays, int actualRentedDays,
			double totalRentalCost, double totalInsuranceCost, LocalDate reservationStart, LocalDate reservationEnd,
			LocalDate actualReturnDate) {
		super();
		this.customerName = customerName;
		this.rentedVehicle = rentedVehicle;
		this.reservedRentalDays = reservedRentalDays;
		this.actualRentedDays = actualRentedDays;
		this.totalRentalCost = totalRentalCost;
		this.totalInsuranceCost = totalInsuranceCost;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.actualReturnDate = actualReturnDate;
	}

	@Override
	public String toString() {
		double dailyRentalCost = rentedVehicle.getDailyCost();
		double dailyInsuranceCost = totalInsuranceCost / actualRentedDays;
		
		double noAdditionInsurance = dailyInsuranceCost;// insurance without discount or addition costs
				
		// Calculating and visualization of insurance addition costs
		String insuranceAddition = "";
	    if (rentedVehicle instanceof Motorcycle && ((Motorcycle) rentedVehicle).getRiderAge() < 25) {
	    	double addition = (rentedVehicle.getValue()*0.0002)*0.2;
	       
	        noAdditionInsurance -= addition;
	        insuranceAddition = "Initial insurance per day: $" + String.format("%.2f",(noAdditionInsurance)) + 
	        		"\nInsurance addition per day: $" + String.format("%.2f", addition)+"\n";
	    }
	    
	    //  Calculating and visualization of insurance discount
	    String discountInsurance = "";
	    if(rentedVehicle instanceof Van && ((Van)rentedVehicle).getDriverExperience() >=5) {
	    	double discount = (rentedVehicle.getValue()*0.0003)*0.15;
	    	
	    	noAdditionInsurance += discount;
	    	discountInsurance = "Initial insurance per day: $" + String.format("%.2f",(noAdditionInsurance)) +
	    			"\nInsurance discount per day: $"+ String.format("%.2f", discount)+"\n";
	    }
		
	    //Display for early returned discounts
	    String earlyReturned = "";
	    if(reservedRentalDays>actualRentedDays) {
	    	int diff = reservedRentalDays - actualRentedDays;
	    	double rentDiscount = dailyRentalCost * diff / 2;
	    	double insuranceDiscount = dailyInsuranceCost * diff;
	    	earlyReturned = "\nEarly return discount for rent: $" + String.format("%.2f", rentDiscount) + "\n"+
	    	"Early return discount for insurance: $" + String.format("%.2f", insuranceDiscount) +"\n";
	    	
	    }
	    
		return "XXXXXXXXXX\n"+ "Date: " + actualReturnDate + "\n"+
				"Customer Name: " + customerName + "\n" +
				"Rented Vehicle: " + rentedVehicle.getBrand() + " "+ rentedVehicle.getModel()+ "\n" +
				"\nReservation start date: " + reservationStart + "\n" +
				"Reservation end date: " + reservationEnd + "\n" +
				"Reserved rental days: " + reservedRentalDays + "\n" +
				"\nActial return date: " + actualReturnDate + " days"+ "\n" +
				"Actual rented days: " + actualRentedDays + " days"+ "\n" +
				"\nRental cost per day: $" + String.format("%.2f",dailyRentalCost) + "\n" +
				insuranceAddition + discountInsurance +
				"Insurance per day: $" + String.format("%.2f", dailyInsuranceCost) +"\n"+
				earlyReturned+
				"\nTotal rent: $" + String.format("%.2f",totalRentalCost) + "\n" +
				"Total insurance: $" + String.format("%.2f",totalInsuranceCost)+ "\n" +
				"Total: $" + String.format("%.2f",(totalRentalCost + totalInsuranceCost)) + "\n" +
				"XXXXXXXXX";
				
	}
}
