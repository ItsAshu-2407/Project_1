package com.bankController.controller;

//Importing packages 
//In this Module Validation process is going on.


import java.io.IOException;
import java.util.regex.Pattern;
import com.bankModel.model.*;
import static java.lang.System.*;

public class bankController {			//bank Controller class 
	public boolean checkUserName(bankModel bmobj) throws IOException {
		String uName = bmobj.getUserName();
		if (Pattern.matches("[a-zA-z@#]{5,13}", uName)) {					//Validating user name.
			return true;
		} else {
			throw new IOException(
					"UserName should contaon only(a-z,A-Z,@,#) these values and it's size must be in between 5-13 characters. ");
		}
	}

	public boolean checkPassword(bankModel bmobj) throws IOException {
		String pass = bmobj.getPassword();
		if (Pattern.matches("[a-zA-Z0-9@#]{6,13}", pass)) {		//Validating password.
			return true;
		} else {
			throw new IOException(
					"Password should contain any of these values(a-zA-Z0-9@#) and it's size must be in between 6-13 characters.");
		}
	}

	public boolean depositAmount(bankModel bmobj, String getPass) throws IOException {
		String password = bmobj.getPassword();
		if (getPass.equals(password)) {				//validating password to deposit amount. 
			return true;
		} else {
			throw new IOException("Incorrect Password. Please try again.");
		}
	}

	public boolean toWithdrawAmount(bankModel bmobj, String getpass, int withdrawAmount) throws IOException {
		String verifyPassword = bmobj.getPassword();
		int accBalance = bmobj.getAccBalance();		
		if (getpass.equals(verifyPassword)) {			//Validating password to withdraw amount.
			if (withdrawAmount < accBalance) {
				return true;
			} else {
				throw new IOException("Sorry can't perform this action beacuse of Insufficient funds inyour Account. ");
			}
		} else {
			throw new IOException("Incorrect password. Please try again.");
		}
	}

}