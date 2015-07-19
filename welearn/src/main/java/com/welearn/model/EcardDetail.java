package com.welearn.model;

/**
 * 一卡通消费明细
 * 
 * @author SikentKim
 *
 */
public class EcardDetail {
	private String describe;
	private String spend;
	private String balance;
	private String date;
	private String people;
	private String placeString;

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getSpend() {
		return spend;
	}

	public void setSpend(String spend) {
		this.spend = spend;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getPlaceString() {
		return placeString;
	}

	public void setPlaceString(String placeString) {
		this.placeString = placeString;
	}

}
