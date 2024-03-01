package bank_chatbot;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankOperations bo = new BankOperations();
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number of requests : ");
		int requests=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<requests;i++) {
			System.out.println("Enter request - "+(i+1)+" : ");
			String request = sc.nextLine();
			
			bo.processOperation(request);
		}

	}

}
