package main;

import java.time.LocalDate;

import models.*;
import utils.Invoice;

public class RentalSystemMain {

	public static void main(String[] args) {
		Car car = new Car("Mitsubishi", "Mirage", 15000, 3);
		Motorcycle motorcycle = new Motorcycle("Triumph ", "Tiger Sport 660", 10000, 20);
		Van van = new Van("Citroen", "Jumper", 20000, 8);

		LocalDate rentedCarStart = LocalDate.of(2024, 6, 3);
		LocalDate rentedCarEnd = LocalDate.of(2024, 6, 13);
		LocalDate rentedCarReturned = LocalDate.of(2024, 6, 13);
		double totalCarInsuranceCost = car.calculateInsuranceCost(10);// 10 - actualRentedDays

		LocalDate rentedMotorStart = LocalDate.of(2024, 6, 3);
		LocalDate rentedMotorEnd = LocalDate.of(2024, 6, 13);
		LocalDate rentedMotorReturned = LocalDate.of(2024, 6, 13);
		double totalMotoInsuranceCost = motorcycle.calculateInsuranceCost(10);// 10 - actualRentedDays
		
		LocalDate rentedVanStart = LocalDate.of(2024, 6, 3);
		LocalDate rentedVanEnd = LocalDate.of(2024, 6, 18);
		LocalDate rentedVanReturned = LocalDate.of(2024, 6, 13);
		double totalVanInsuranceCost = van.calculateInsuranceCost(10);// 10 - actualRentedDays
		
		Invoice carInvoice = new Invoice("John Doe", car, 10, 10, car.calculateRentalCost(10, 10),
				totalCarInsuranceCost, rentedCarStart, rentedCarEnd, rentedCarReturned);
		Invoice motorcycleInvoice = new Invoice("Mary Johnson", motorcycle, 10, 10, motorcycle.calculateRentalCost(10, 10),
				totalMotoInsuranceCost, rentedMotorStart, rentedMotorEnd, rentedMotorReturned);
		Invoice vanInvoice = new Invoice("John Markson", van, 15, 10, van.calculateRentalCost(15, 10),
				totalVanInsuranceCost, rentedVanStart, rentedVanEnd, rentedVanReturned);

		
		System.out.println(carInvoice);
		System.out.println(motorcycleInvoice);
		System.out.println(vanInvoice);

		Motorcycle m1 = new Motorcycle("Yamaha","Ninja",15000,28);
		LocalDate rentedM1Start = LocalDate.of(2024, 6, 15);
		LocalDate rentedM1End = LocalDate.of(2024, 6, 20);
		LocalDate rentedM1Returned = LocalDate.of(2024, 6, 20);
		double totalM1InsuranceCost = m1.calculateInsuranceCost(5);// 5 - actualRentedDays
		
		Invoice m1Invoice = new Invoice("Bon Jovi", m1,5,5,m1.calculateRentalCost(5,5),totalM1InsuranceCost,
				rentedM1Start,rentedM1End,rentedM1Returned);
		
		System.out.println(m1Invoice);
	}

}
