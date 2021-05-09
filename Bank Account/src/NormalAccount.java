
public class NormalAccount {
	protected String name;
	protected int accNumber;
	protected int balance;
	
	
	public NormalAccount(String name, int accNumber, int balance) {
		super();
		if (this.balance < 50000) {
			System.out.println("Can not open account");
		}else {
			this.name = name;
			this.accNumber = accNumber;
			this.balance = balance;
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAccNumber() {
		return accNumber;
	}


	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}



	public void deposit(int money) {
		if(money < 0) {
			System.out.println("Must positive");
		}else {
			this.balance += money;
			System.out.println("Deposit success");
		}
	}
	
	
	public void withDraw(int money) {
		if(this.balance - (money + 5000) < 50000 ) {
			System.out.println("Money withDraw too much");
		}else {
			this.balance -= (money + 5000);
			System.out.println("Withdraw success.Fee is 5000");
		}
	}

}
