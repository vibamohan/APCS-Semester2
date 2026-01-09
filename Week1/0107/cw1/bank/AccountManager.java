
package bank;

public class AccountManager {
	private Account[] account;
  
  public AccountManager() {
  	account = new Account[3];
    account[0] = new Account("John", 1234, 10.10);
    account[1] = new Account("Jen", 1111, 99.99);
    account[2] = new Account("Jay", 4321, 11.11);

  }
  
  public void printInfo() {
  	for (Account acc : account) {
    	System.out.println(acc);
    }
  }
}
