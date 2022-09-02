package com.finzly.fxtrading.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.finzly.fxtrading.model.TradingData;

public class DisplayTradeOptions {
	public void showTadingOperations(ArrayList<TradingData> list_data) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		int choice;
		try {
			do {
				System.out.println("Enter your choice\n" + "1.Book Trade\n" + "2.Print Trade\n" + "3.Exit\n");
				choice = scanner.nextInt();

				switch (choice) {
					case 1:
						BookTrade book = new BookTrade();
//						  //To change rate 
//						 System.out.println("Enter the rate:"); 
//						  float rate=scanner.nextFloat();
//						 book.setRate(rate);
						book.bookTrade(list_data);
						break;
					case 2:
						PrintTrade print = new PrintTrade();
						print.printTradeData(list_data);
						break;
					case 3:
						System.out.println("Do you really want to exit (y/n)");
						String exit_choice = scanner.next().trim().toUpperCase();
						if (exit_choice.equals("Y") || exit_choice.equals("YES")) {
							System.out.println("Bye - have a good day");
							exit = true;
							break;
						}
						else if (exit_choice.equals("N") || exit_choice.equals("NO"))
							break;
						else
						System.out.println("Invalid Option try again..");
						break;
					default:
						System.out.println("Invalid choice...");
						break;
				}
			} while (exit == false);
		} catch (Exception e) {
			System.out.println("Invalid choice try again");
			showTadingOperations(list_data);
		}

		scanner.close();

	}

}
