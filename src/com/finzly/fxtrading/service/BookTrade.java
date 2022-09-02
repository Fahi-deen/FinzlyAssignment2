package com.finzly.fxtrading.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.finzly.fxtrading.model.TradingData;

public class BookTrade {
	static Long tradeno = 0L;
	private String customerName;
	private String currencyPair;
	private double amount;
	private String displayAmount;
	private float rate = 66.00f;
	private String printRate;
	TradingData trade = new TradingData();

	public BookTrade() {
	}

	private void getRateValue() {
		System.out.println("You are transferring INR " + PrintTrade.displayAmount(amount) + " to " + customerName);
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	Scanner scanner = new Scanner(System.in);

	public void bookTrade(ArrayList<TradingData> data) {
		tradeno++;

		System.out.println("Enter customer Name");
		this.customerName = scanner.nextLine().trim();
		System.out.println("Enter Currency Pair");
		this.currencyPair = CurrencyPairChecker().trim();
		this.amount = amountCalculator(amount, rate);
		displayAmount = PrintTrade.displayAmount(amount);
		printRate = displayPrintRate();
		;

		if (printRate.equals("y") || printRate.equals("yes"))
			getRateValue();
		trade.setTradeNo(tradeno);
		trade.setCustomerName(customerName);
		trade.setCurrencyPair(currencyPair);
		trade.setAmount(amount);
		trade.setRate(rate);
		System.out.println("**********************************************");
		bookOrCancelTrade(data);

	}

	private Double amountCalculator(Double amount, float rate) {
		System.out.println("Enter amount to transfer");
		amount = scanner.nextDouble();
		if (amount <= 0) {
			System.out.println("Enter amount above 0");
			return amountCalculator(this.amount, this.rate);
		}
		amount = amount * this.rate;
		return amount;

	}

	private String displayPrintRate() {
		System.out.println("Do you want to get Rate(y/n)");
		this.printRate = scanner.next().trim().toLowerCase();
		if (printRate.equals("y"))
			return printRate;
		else if (printRate.equals("n"))
			return printRate;
		System.out.println("Invalid choice\nEnter only y to print rate or n to not print the rate");
		return displayPrintRate();

	}

	private String CurrencyPairChecker() {
		this.currencyPair = scanner.nextLine().trim().toUpperCase();
		if (currencyPair.equals("USDINR")) {
			return currencyPair;
		}
		System.out.println("Only USDINR is accepted Try Again..");
		return CurrencyPairChecker();

	}

	private void bookOrCancelTrade(ArrayList<TradingData> data) {
		String choice;
		System.out.println("Enter Book to Book this Trade\n" + "Enter Cancel to cancel this Trade");
		System.out.println("**********************************************");
		choice = scanner.next().trim().toLowerCase();

		switch (choice) {
			case "book":
				data.add(trade);
				System.out.println("Trade for USDINR has been booked with rate " + rate + ", The amount of Rs "
						+ displayAmount + " will  be transferred in 2 working days to " + customerName+"..");
				break;
			case "cancel":
				tradeno--;
				System.out.println("Trade is Canceled..");
				break;
			default:
				System.out.println("Invalid option try again...");
				bookOrCancelTrade(data);

		}
	}

}
