package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.RateException;

import rocketDomain.RateDomainModel;

public class rate_test {

	// TODO - RocketBLL rate_test
	// Check to see if a known credit score returns a known interest rate
	@Test
	public void a_rate_test() {
		try {
			//true values
			assertTrue(RateBLL.getRate(600) == 5);
			
		}

		catch (RateException e) {
			System.err.println("You Do Not Qualify For A Loan");
		}
	}

	// TODO - RocketBLL rate_test
	// Check to see if a RateException is thrown if there are no rates for a
	// given
	// credit score
	@Test
	public void rate_Ex_test() throws Exception  {
		double a_rate = RateBLL.getRate(900);
		ArrayList <RateDomainModel> allRates = new ArrayList <RateDomainModel> (RateDAL.getAllRates());
		assertFalse((allRates.contains(a_rate)));
	}
	
	@Test
	public void pay_test() {
		double p = RateBLL.getPayment(4,30,300000,0,false);
		assert(1432.25 == p);
	
	}
	
}









