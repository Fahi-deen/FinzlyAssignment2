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
		System.out.println("Enter amount to transfer");
		this.amount = scanner.nextDouble();
		amount = amount * rate;
		displayAmount = PrintTrade.displayAmount(amount);
		System.out.println("Do you want to get Rate(y/n)");
		this.printRate = scanner.next().trim().toLowerCase();
		if (printRate.equals("y"))
			getRateValue();
		trade.setTradeNo(tradeno);
		trade.setCustomerName(customerName);
		trade.setCurrencyPair(currencyPair);
		trade.setAmount(amount);
		trade.setRate(rate);
		System.out.println("**********************************************");
		bookOrCancelTrade(data);

	}

	private String CurrencyPairChecker() {
		this.currencyPair = scanner.nextLine().trim().toUpperCase();
		if (currencyPair.equals("USDINR")) {
			return currencyPair;
		}
		System.out.println("Only USRINR is accepted Try Again..");
		return CurrencyPairChecker();

	}

	private void bookOrCancelTrade(ArrayList<TradingData> data) {
		String choice;
		System.out.println("Enter Book to Book this Trade\n" + "Enter Cancel to cancel this Trade\n");
		choice = scanner.next().trim().toLowerCase();

		switch (choice) {
			case "book":
				data.add(trade);
				System.out.println("Trade for USDINR has been booked with rate" + rate + ", The amount of Rs "
						+ displayAmount + " will  be transferred in 2 working days to " + customerName);
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
