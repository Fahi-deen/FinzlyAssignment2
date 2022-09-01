package com.finzly.fxtrading.service;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.finzly.fxtrading.model.TradingData;

public class PrintTrade {

	TradingData data=new TradingData();
	public void printData(ArrayList<TradingData> printData) {
		if(printData.isEmpty()) System.out.println("No data to display..");
		else {
		System.out.println("TradeNo\tCurrencyPair\tCustomerName\tAmount\t\tRate ");
		for(TradingData data:printData) {
			System.out.println(data.getTradeNo()+"\t"+data.getCurrencyPair()+"\t\t"+data.getCustomerName()+"\t\t"+"INR "+displayAmount(data.getAmount())+"\t"+data.getRate());
		}}
	}
	public static String displayAmount(Double amount) {
		DecimalFormat df = new DecimalFormat("###,###,###");
        String displayAmount=df.format(amount).trim();
        return displayAmount;
	}
	
	
}
