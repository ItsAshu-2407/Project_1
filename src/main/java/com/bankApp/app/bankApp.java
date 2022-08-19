
/**
 * @author Ashutosh Kumar.
 * 
 * Hello guys I welcome you all here, It is an application of a Finserv Bank to complete the needs of it's customer. 
 * 
 * A Program To Illustrate Encapsulation and Abstraction. It also includes the concept of exception handling.
 */


package com.bankApp.app;

import java.io.IOException;
import com.bankModel.model.*;
import com.bankController.controller.*;
import static java.lang.System.*;
import java.util.*;

public class bankApp {							// Main class.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		//Scanner class object is created.
		bankModel bmobj = new bankModel();			//bank model object is created.	
		bankController bcobj = new bankController();		//bank controller object is created.
		out.println("------Welcome to Finserv Bank------");
		out.println("Enter your User Name:- ");
		String userName = sc.next();
		bmobj.setUserName(userName);			//user name is taken from the user to save it in bank database.
		try {
			if (bcobj.checkUserName(bmobj)) {			//validating user name.
				out.println("Enter a valid Password:- ");
				String pass = sc.next();
				bmobj.setPassword(pass);
				try {
					if (bcobj.checkPassword(bmobj)) {			//validating password.
						out.println("Enter Account Number:- ");		
						int accNumber = sc.nextInt();			//taking input of Details of the customer.
						bmobj.setAccNumber(accNumber);				
						out.println("Enter Minimum Balance:- ");
						int minBalance = sc.nextInt();
						bmobj.setAccBalance(minBalance);
						int var = 0;
						while (var < 4) {			//Giving choice to the customer to perform his/her desired action. 
							out.println(
									"Choose Number to Perform various action.\n 1. To Deposit Amount. \n 2. To Withdraw Amount. \n 3. To Display Account Details. \n 4. Exit.\n ");
							var = sc.nextInt();
							switch (var) {
							case 1 -> {
								out.println("Enter Password to Deposit.");			//Checking or validating password to deposit amount.
								String getPass = sc.next();
								try {
									if (bcobj.depositAmount(bmobj, getPass)) {
										out.println("Enter Amount to Deposit in your Account:- ");
										int addMoney = sc.nextInt();					//taking input of deposit amount.
										bmobj.setDepositAmount(addMoney);				//Updating customer account balance.
										out.println("your account balance is :" + bmobj.getAccBalance());
									}
								} catch (Exception e) {
									out.println(e.getMessage());			//printing error message if occurred.
								}
							}
							case 2 -> {
								out.println("Enter Password to Withdraw Amount:- ");
								String getPass = sc.next();					//Taking input of Password to validate.
								out.println("Enter How much Money you want to withdraw:- ");
								int withdrawAmount = sc.nextInt();			//Taking input of withdraw amount.
								try {
									if (bcobj.toWithdrawAmount(bmobj, getPass, withdrawAmount)) {
										bmobj.setWithdrawAmount(withdrawAmount);		//Withdrawing amount from customer account and updating it.
										out.println("Your Money withdrawn Succesfully. \n Now You have: "
												+ bmobj.getAccBalance() + " in you Account");
									}
								} catch (Exception e) {
									out.println(e.getMessage());			//Printing error message if occurred.
								}
							}
							case 3 -> {
								out.println("-----Your Account Details are-----\n" + bmobj.toString());			//Displaying Customer account details.
							}
							default -> System.exit(0);		//Exiting the program by customer choice.
							}
						}
					}
				} catch (Exception e) {
					out.println(e.getMessage());			//Printing error message.
				}
			}
		} catch (Exception e) {
			out.println(e.getMessage() + " Please try again.");
			System.exit(0);				//Exiting from the program if user gives wrong input.
		}
	}
}
