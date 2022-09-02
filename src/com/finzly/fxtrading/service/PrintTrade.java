package com.finzly.fxtrading.service;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.finzly.fxtrading.model.TradingData;

public class PrintTrade {

	TradingData data = new TradingData();

	public void printTradeData(ArrayList<TradingData> printData) {
		if (printData.isEmpty())
			System.out.println("No Trading data to display..");
		else {
			System.out.println(
					"-----------------------------------------------------------------------------------------------");
			System.out.printf("%s %15s %23s %16s %28s\n", "TradeNo", "CurrencyPair", "CustomerName", "Amount", "Rate");
			System.out.println(
					"-----------------------------------------------------------------------------------------------");
			for (TradingData data : printData) {
				System.out.format("%2s %15s %28s %12s %1s %16s %1s", data.getTradeNo(), data.getCurrencyPair(),
						data.getCustomerName(), "INR ", displayAmount(data.getAmount()), "\t", data.getRate());
				System.out.println();
			}
		}
	}

	// To display rate separated by commas Eg: 160000 will be 16,000
	public static String displayAmount(Double amount) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		String displayAmount = df.format(amount).trim();
		return displayAmount;
	}

}
