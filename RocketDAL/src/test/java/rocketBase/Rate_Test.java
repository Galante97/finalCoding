package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import rocketDomain.RateDomainModel;
import util.HibernateUtil;

public class Rate_Test {

	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	//Query query = session.createQuery(hql);
	//List results = query.list();
	
	@Test
	public void check_credit_score() {
		
	}
	 
	 
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		 
		assert(1==1);
	}

}
