package com.finzly.fxtrading.run;

import java.util.ArrayList;

import com.finzly.fxtrading.model.TradingData;
import com.finzly.fxtrading.service.DisplayTradeOptions;

public class FxTradingRun {

	public static ArrayList<TradingData> list_data = new ArrayList<>();

	public static void main(String[] args) {
       DisplayTradeOptions trade=new DisplayTradeOptions();
       trade.showTadingOperations(list_data);
	}

	
}
