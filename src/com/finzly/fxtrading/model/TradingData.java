package com.finzly.fxtrading.model;

public class TradingData {
	private Long tradeNo;
	private String currencyPair;
	private String customerName;
	private double amount;
	private float rate;

	public TradingData() {
	}

	public TradingData(Long tradeNo, String customerName, String currencyPair, double amount, float rate) {
		super();
		this.tradeNo = tradeNo;
		this.currencyPair = currencyPair;
		this.customerName = customerName;
		this.amount = amount;
		this.rate = rate;
	}

	public Long getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(Long tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "TradingData [tradeNo=" + tradeNo + ", currencyPair=" + currencyPair + ", customerName=" + customerName
				+ ", amount=" + amount + ", rate=" + rate + "]";
	}

}
