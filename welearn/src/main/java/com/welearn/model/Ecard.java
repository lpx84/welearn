package com.welearn.model;

/**
 * 一卡通信息类
 * 
 * @author SikentKim
 *
 */
public class Ecard {
	private String name;// 姓名
	private String state;// 状态
	private String specialWallet;// 专用钱包
	private String wallet;// 主钱包
	private String allowance;// 补助钱包

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSpecialWallet() {
		return specialWallet;
	}

	public void setSpecialWallet(String specialWallet) {
		this.specialWallet = specialWallet;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public String getAllowance() {
		return allowance;
	}

	public void setAllowance(String allowance) {
		this.allowance = allowance;
	}

}
