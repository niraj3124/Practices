package payment.com.dao;

import payment.com.bean.PaymentDetails;
import payment.com.exception.PaymentIssueException;


public interface IPaymentDAO {
	
	public int addPayment(PaymentDetails pd) throws PaymentIssueException;
	public PaymentDetails retrieveByTransactionId(int searchid) throws PaymentIssueException;
}
