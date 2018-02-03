package M2;

import java.util.ArrayList;

public class Customer {

	private String name;
	private long cusNum;
	private double discount;
	private ArrayList<Account> listOfAccounts = new ArrayList<Account>();
	
	Customer(String inName, double inDiscount, long inCusNum){
		
		this.name = inName;
		this.discount = inDiscount;
		this.cusNum = inCusNum;
		
	}
	
	long createCusNum() {
		
		return (long)(Math.random() * Long.MAX_VALUE);
		
	}
	
	boolean createAccount(String inType, String inBalance) {
		
		int checkInType = Account.validType(inType);
		double checkInBalance = Account.validNumber(inBalance);
		
		if(checkInType != -1 && checkInBalance != 0 ) {
			
			this.listOfAccounts.add(new Account(checkInType, checkInBalance));
			return true;
			
		}
		
		else {
			return false;
		}
		
	}
	
	boolean transfer(int receiverIndex, int drawerIndex, double inAmount) {
		
		if()
		
	}
}
