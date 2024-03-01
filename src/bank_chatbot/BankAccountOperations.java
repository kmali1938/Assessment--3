package bank_chatbot;

public interface BankAccountOperations {
	void deposit(double amount);
	void withdraw(double amount);
	double processOperation(String message);

}
