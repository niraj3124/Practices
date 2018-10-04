package payment.com.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import payment.com.bean.PaymentDetails;
import payment.com.dbutil.DBConnectivity;
import payment.com.dbutil.IQueryMapper;
import payment.com.exception.PaymentIssueException;


public class PaymentDAOImpl implements IPaymentDAO{

	PaymentDetails pd = null;
	Logger log = null;

	public PaymentDAOImpl() {
		PropertyConfigurator.configure("src/resources/log4j.properties");
		log = Logger.getRootLogger();
		log.setLevel(Level.ALL);

	}

	Connection conn = null;
	@Override
	public int addPayment(PaymentDetails pd) throws PaymentIssueException {
		int retId = 0;
		try {
			//pd= new PaymentDetails();
			log.info("program for insertion started");
			conn = DBConnectivity.getConnected();
			PreparedStatement pst = conn.prepareStatement(IQueryMapper.INSERT_PAYMENT_INFO);

			pst.setString(1, pd.getName());
			pst.setInt(2, pd.getAccnum());
			pst.setInt(3, pd.getOtp());
			pst.setInt(4, pd.getAmount());
			int status = pst.executeUpdate();
			log.info("data is getting stored");
			if (status >= 1) {
				pst = conn.prepareStatement(IQueryMapper.PAY_SEQ_CURR_ID);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					retId = rs.getInt(1);
					log.info("Transaction Successfull with transaction id :: "+retId);

				}
			}

		} 
		catch (SQLException e) {
			log.error("error : "+e.getMessage());
			// throw it user defined excep
			throw new PaymentIssueException("DB problem : " + e.getMessage());

		}
		return retId;

	}
	public PaymentDetails retrieveByTransactionId(int searchid) {

		try
		{
			conn = DBConnectivity.getConnected();
			PreparedStatement pst = conn.prepareStatement(IQueryMapper.RETRIEVE_PAYMENT_BY_ID);
			pst.setInt(1, searchid);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				pd= new PaymentDetails();
				pd.setTid(rs.getInt(1));
				pd.setTransactiondate(rs.getString(2));
				pd.setName(rs.getString(3));
				pd.setAccnum(rs.getInt(4));
				pd.setOtp(rs.getInt(5));
				pd.setAmount(rs.getInt(6));
				
			}
			else
			{
				System.out.println("Not Found");
				
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error!!"+e.getMessage());
		}
		return pd;
	}



}
