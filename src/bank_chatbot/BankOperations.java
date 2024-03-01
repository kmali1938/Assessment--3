package bank_chatbot;

//import java.util.Map;

public class BankOperations implements BankAccountOperations{
	private double balance=0;

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		balance += amount;
		System.out.println("Amount deposited successfully");
		System.out.println("New Balance is : "+balance);
		
	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if(balance >= amount) {
			balance = balance-amount;
			System.out.println("Withdrawal successful!!");
			System.out.println("New Balance is : "+balance);
		}else {
			System.out.println("Insufficient balance for withdrawal!");
			System.out.println("Your Balance is : "+balance);
		}
		
	}
	
	private boolean isActionKeyword(String word) {
	    String[] actionKeywords = {"see", "show", "deposit", "put", "invest", "transfer", "withdraw", "pull"};
	    for (String keyword : actionKeywords) {
	    	String a = keyword.toLowerCase();
	        if (a.equals(word.toLowerCase())) {
	            return true;
	        }
	    }
	    return false;
	    
	}

	@Override
	public double processOperation(String message) {
		// TODO Auto-generated method stub
		String[] words = message.split(" ");

		String action="None";
		double amount =-1;
		
		//String word = words[0].toLowerCase();
		
		for(String word : words) {
			if(isActionKeyword(word)) {
				action = word.toLowerCase();
			}else {
				try {
					amount = Double.parseDouble(word);
				}catch(NumberFormatException e) {
					//e.printStackTrace();
				}
			}
			
		}
		
		switch(action) {
			case "see":
				return balance;
				//break;
				
			case "show":
				return balance;
				//break;
			
			case "deposit":
	            if (amount != -1) {
	                deposit(amount);
	            } else {
	                System.out.println("Amount not specified.");
	            }
				break;
			
			case "put" :
	            if (amount != -1) {
	                deposit(amount);
	            } else {
	                System.out.println("Amount not specified.");
	            }
				break;
				
			case "invest" :
	            if (amount != -1) {
	                deposit(amount);
	            } else {
	                System.out.println("Amount not specified.");
	            }
				break;
				
			case "transfer" :
	            if (amount != -1) {
	                deposit(amount);
	            } else {
	                System.out.println("Amount not specified.");
	            }
				break;
				
			case "withdraw" :
				 if (amount != -1) {
		                withdraw(amount);
		            } else {
		                System.out.println("Amount not specified.");
		            }
				break;
				
			case "pull" :
				 if (amount != -1) {
		                withdraw(amount);
		            } else {
		                System.out.println("Amount not specified.");
		            }
				break;
				
			default :
				System.out.println("Im having issues understanding");
				System.out.println("Please use workds like (see,show,deposit,put,invest,transfer,withdraw,pull)");
				
				
		}
		return balance;
	}

}
