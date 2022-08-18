package com.bankModel.model;

import com.bankApp.app.*;

public class bankModel {
	private int accNumber;
	private String userName;
	private String password;
	private int accBalance;
	private int depositAmount;
	private int withdrawAmount;

	public int getDepositAmount() {
		return depositAmount;
	}

	public int getWithdrawAmount() {
		return withdrawAmount;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
		accBalance += depositAmount;
	}

	public void setWithdrawAmount(int withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
		accBalance -= withdrawAmount;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(int accBalance) {
		this.accBalance = accBalance;
	}

	@Override
	public String toString() {
		return "bankModel [accNumber=" + accNumber + ", password=" + password + ", accBalance=" + accBalance
				+ ", depositAmount=" + depositAmount + ", withdrawAmount=" + withdrawAmount + ", userName=" + userName
				+ "]";
	}

	
}
