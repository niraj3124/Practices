package payment.com.dbutil;

public interface IQueryMapper {
	
	public static final	String INSERT_PAYMENT_INFO="INSERT INTO payment values(pay_seq.NEXTVAL,SYSDATE,?,?,?,?)";
	public static final	String RETRIEVE_PAYMENT_BY_ID="SELECT * FROM payment where tid=?";
	public static final	String PAY_SEQ_CURR_ID="SELECT pay_seq.currval FROM dual";
	

}
