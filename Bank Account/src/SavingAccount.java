
public class SavingAccount extends NormalAccount {
	private float annualRate;
	
	public float getAnnualRate() {
		return annualRate;
	}
	public void setAnnualRate(float annualRate) {
		this.annualRate = annualRate;
	}
	public SavingAccount(String name, int accNumber, int balance, float annualRate) {
		super(name, accNumber, balance);
		this.annualRate = annualRate;
	}
	
	public float monthlyInterest() {
		return (this.balance * this.annualRate)/12;
	}
	
	public void depositSavingAccount(int money) {
		if (money < 0) {
			System.out.println("Must positive");
		}else {
			this.balance += money;
			System.out.println("Deposit success");
		}
	}
	

}
