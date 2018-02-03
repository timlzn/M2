package M2;

public class Account {
	
	private double balance;
	private int type;
	
	Account(int inType, double inBalance){
		
		this.type = inType;
		this.balance = inBalance;
		
	}
	
	double getBalance() {
		
		return this.balance;
		
	}
	
	boolean setBalance(double newBalance) {
		
		if(newBalance >= 0) {
			
			this.balance = newBalance;
			
			return true;
			
		}
		
		else {
			
			return false;
			
		}
		
	}

	static double validNumber(String inNumber) {
		
		for(int i = 0; i < inNumber.length(); i++) {
			
			if(inNumber.charAt(i) > '9' || inNumber.charAt(i) < '0') {
				
				if(inNumber.charAt(i) != '.' && i != inNumber.length() - 3) {
					
					return -1;
					
				}
				
			}
			
		}
		
		return Double.parseDouble(inNumber);
		
	}
	
	static int validType(String inType) {
		
		if(inType.equals("check")){
			
			return 1;
			
		}
		
		else if(inType.equals("save")) {
			
			return 2;
			
		}
		
		else {
			
			return 0;
			
		}
		
	}
	
	int deposit(String inAmount, double discount) {
		
		double isValid = validNumber(inAmount);
		
		if(isValid == -1) {
			return 0;
		}
		
		else if(this.type == 1) {
				
			this.setBalance(this.getBalance() + isValid);
			return 1;
				
		}
		
		else if(this.type == 2) {
			
			this.setBalance(this.getBalance() + isValid * (1 + discount));
			return 1;
			
		}
		
		else {
			return 2;
		}
		
	}
	
	int withdrawal(String inAmount, double discount) {
		
		double isValid = validNumber(inAmount);
		
		if(isValid == -1) {
			return 0;
		}
		
		else if(this.type == 1) {
			
			if(this.setBalance(this.getBalance() - (isValid * (1 + discount)))){
				return 1;
			}
			
			else if(!this.setBalance(this.getBalance() - (isValid * (1 + discount)))){
				return 2;
			}
			
			else {
				return 4;
			}
			
		}
		
		else if(this.type == 2) {
			
			if(isValid < 1000) {
				return 3;
			}
			
			else if(this.setBalance(this.getBalance() - isValid)) {
				return 1;
			}
			
			else if(!this.setBalance(this.getBalance() - isValid)){
				return 2;
			}
			
			else {
				return 4;
			}
			
			
		}
		
		else {
			return 4;
		}
		
	}

	
}
