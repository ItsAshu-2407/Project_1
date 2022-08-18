package com.bankApp.app;

/**
 * Hello world!
 *
 */
import java.io.IOException;
import com.bankModel.model.*;
import com.bankController.controller.*;
import static java.lang.System.*;
import java.util.*;

public class bankApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		bankModel bmobj = new bankModel();
		bankController bcobj = new bankController();
		out.println("------Welcome to Finserv Bank------");
		out.println("Enter your User Name:- ");
		String userName = sc.next();
		bmobj.setUserName(userName);
		try {
			if (bcobj.checkUserName(bmobj)) {
				out.println("Enter a valid Password:- ");
				String pass = sc.next();
				bmobj.setPassword(pass);
				try {
					if (bcobj.checkPassword(bmobj)) {
						out.println("Enter Account Number:- ");
						int accNumber = sc.nextInt();
						bmobj.setAccNumber(accNumber);
						out.println("Enter Minimum Balance:- ");
						int minBalance = sc.nextInt();
						bmobj.setAccBalance(minBalance);
						int var = 0;
						while (var < 4) {
							out.println(
									"Choose Number to Perform various action.\n 1. To Deposit Amount. \n 2. To Withdraw Amount. \n 3. To Display Account Details. \n 4. Exit.\n ");
							var = sc.nextInt();
							switch (var) {
							case 1 -> {
								out.println("Enter Password to Deposit.");
								String getPass = sc.next();
								try {
									if (bcobj.depositAmount(bmobj, getPass)) {
										out.println("Enter Amount to Deposit in your Account:- ");
										int addMoney = sc.nextInt();
										bmobj.setDepositAmount(addMoney);
										out.println("your account balance is :" + bmobj.getAccBalance());
									}
								} catch (Exception e) {
									out.println(e.getMessage());
								}
							}
							case 2 -> {
								out.println("Enter Password to Withdraw Amount:- ");
								String getPass = sc.next();
								out.println("Enter How much Money you want to withdraw:- ");
								int withdrawAmount = sc.nextInt();
								try {
									if (bcobj.toWithdrawAmount(bmobj, getPass, withdrawAmount)) {
										bmobj.setWithdrawAmount(withdrawAmount);
										out.println("Your Money withdrawn Succesfully. \n Now You have: "
												+ bmobj.getAccBalance() + " in you Account");
									}
								} catch (Exception e) {
									out.println(e.getMessage());
								}
							}
							case 3 -> {
								out.println("-----Your Account Details are-----\n" + bmobj.toString());
							}
							default -> System.exit(0);
							}
						}
					}
				} catch (Exception e) {
					out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			out.println(e.getMessage() + " Please try again.");
			System.exit(0);
		}
	}
}
