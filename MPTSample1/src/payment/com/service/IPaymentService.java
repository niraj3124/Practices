package payment.com.service;

import payment.com.bean.PaymentDetails;
import payment.com.exception.PaymentIssueException;

public interface IPaymentService {
	

	int addPayment(PaymentDetails pd) throws PaymentIssueException;
	PaymentDetails retrieveByTransactionId(int searchid) throws PaymentIssueException;

}
