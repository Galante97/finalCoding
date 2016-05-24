package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	
	//	* Add RateRomainModel as an attribute
	private RateDomainModel rateModel;
	
	//	* Create a constructor, passing in RateDomainModel
	public RateException(RateDomainModel rateModel) {
		super();
		this.rateModel = rateModel;
	}
	
	public RateException() {
		System.out.println("You do not qualify");
	}
	
	//	* Create a getter (no setter, set value only in Constructor)
	public RateDomainModel getRateModel() {
		return rateModel;
	}
	
	
	
}
