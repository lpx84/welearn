package com.welearn.model;

/**
 * 这是本月流量使用情况的类
 * 
 * @author SikentKim
 *
 */
public class NetFlow {
	private String balance;//账户余额
	private String time;//本月时长
	private String flow;//本月流量
	private String restFlow;//剩余流量
	private String extraFee;//超出费用

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public String getRestFlow() {
		return restFlow;
	}

	public void setRestFlow(String restFlow) {
		this.restFlow = restFlow;
	}

	public String getExtraFee() {
		return extraFee;
	}

	public void setExtraFee(String extraFee) {
		this.extraFee = extraFee;
	}

	@Override
	public String toString() {
		return "NetFlow [balance=" + balance + ", time=" + time + ", flow="
				+ flow + ", restFlow=" + restFlow + ", extraFee=" + extraFee
				+ "]";
	}

}
