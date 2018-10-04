package payment.com.bean;

public class PaymentDetails {
	
	int tid;
	String transactiondate=null;
	String name=null;
	int accnum;
	int otp;
	int amount;
	
	
	public PaymentDetails() {
		super();
	}


	@Override
	public String toString() {
		return "PaymentDetails [tid=" + tid + ", transactiondate="
				+ transactiondate + ", name=" + name + ", accnum=" + accnum
				+ ", otp=" + otp + ", amount=" + amount + "]";
	}


	public PaymentDetails(int tid, String transactiondate, String name,
			int accnum, int otp, int amount) {
		super();
		this.tid = tid;
		this.transactiondate = transactiondate;
		this.name = name;
		this.accnum = accnum;
		this.otp = otp;
		this.amount = amount;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getTransactiondate() {
		return transactiondate;
	}


	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAccnum() {
		return accnum;
	}


	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}


	public int getOtp() {
		return otp;
	}


	public void setOtp(int otp) {
		this.otp = otp;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public static void main(String[] args) {
		

	}

}
