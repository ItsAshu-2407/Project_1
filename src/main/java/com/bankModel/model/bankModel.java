/*
 		This module contains the database of the bank where implementation details and user details are stored. Only Necessary details are shared with the customer.
*/
package com.bankModel.model;

import com.bankApp.app.*;

public class bankModel { // bank model class.
	private int accNumber;
	private String userName;
	private String password;
	private int accBalance;
	private int depositAmount;
	private int withdrawAmount;

	public int getDepositAmount() { // Deposit amount method to get deposit amount from user.
		return depositAmount;
	}

	public int getWithdrawAmount() { // Withdraw amount method to display withdraw amount from user and to use it in
										// another class.
		return withdrawAmount;
	}

	public int getAccNumber() { // Get Account number method is to get account number from the the database.
		return accNumber;
	}

	public void setAccNumber(int accNumber) { // Set Account number is the method to set account number in the bank
												// database.
		this.accNumber = accNumber;
	}

	public String getUserName() { // Get user name method is to get user name from the database.
		return userName;
	}

	public void setDepositAmount(int depositAmount) { // set Deposit amount method to set deposit amount taken from the
														// user in the bank database.
		this.depositAmount = depositAmount; // Account balance is also updated here after adding the deposit amount.
		accBalance += depositAmount;
	}

	public void setWithdrawAmount(int withdrawAmount) { // set withdraw amount method to set withdraw amount taken from
														// the user in the bank database.
		this.withdrawAmount = withdrawAmount;
		accBalance -= withdrawAmount; // Account balance is also updated here after subtracting the withdraw amount.
	}

	public void setUserName(String userName) { // set user name method to set user name taken from the user in the bank
												// database.
		this.userName = userName;
	}

	public String getPassword() { // get password is used to get password from the database.
		return password;
	}

	public void setPassword(String password) { // set password is used to set the password in database of the bank for
												// its further use.
		this.password = password;
	}

	public int getAccBalance() { // get account balance is the method display output of account balance to the
									// user, and it can also be used in other classes..
		return accBalance;
	}

	public void setAccBalance(int accBalance) { // set account balance is the method to set account balance in the
												// database.
		this.accBalance = accBalance;
	}

	@Override
	public String toString() { // to string is the method to display all the details of the customer as output.
		return "bankModel [accNumber=" + accNumber + ", password=" + password + ", accBalance=" + accBalance
				+ ", depositAmount=" + depositAmount + ", withdrawAmount=" + withdrawAmount + ", userName=" + userName
				+ "]";
	}

}
