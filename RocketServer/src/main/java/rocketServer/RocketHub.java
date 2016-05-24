package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) throws RateException {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			//	TODO - RocketHub.messageReceived

			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			try {
				lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
			} catch (RateException e) {
				System.out.println("Error cannot make loan request");
			}
			
			//		If exception, show error message, stop processing
			//		If no exception, continue
			//	Determine if payment, call RateBLL.getPayment
			RateBLL.getPayment(lq.getdRate(), lq.getiTerm(), lq.getdAmount(), 0, false);
			//	
			//	you should update lq, and then send lq back to the caller(s)
			sendToAll(lq);
		}
	}
}
