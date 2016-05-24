package rocket.app.view;

import java.awt.Button;
import java.awt.TextField;

import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)
	@FXML
	private TextField in_Income;
	@FXML
	private TextField in_Expenses;
	@FXML
	private TextField in_CreditScore;
	@FXML
	private TextField in_HouseCost;
	@FXML
	private ComboBox<String> combo_terms;
	@FXML
	private Label Income;
	@FXML
	private Label Expenses;
	@FXML
	private Label CreditScore;
	@FXML
	private Label HouseCost;
	@FXML
	private Label Term;
	@FXML
	private Label out_MortgagePayment;
	@FXML 
	private Button calc_button;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void dropDown() {
		ObservableList<String> drop_options = FXCollections.observableArrayList("15 Years", "30 Years");
		combo_terms.setItems(drop_options);
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		
		lq.setdAmount(Double.parseDouble(in_HouseCost.getText()));
		lq.setiCreditScore((int)Double.parseDouble(in_CreditScore.getText()));

		//combo box
		if (combo_terms.getValue()=="15 Years") {
			lq.setiTerm(15*12);
		}
		else if(combo_terms.getValue() == "30 Years") {
			lq.setiTerm(30*12);
		}

		a.setLoanRequest(lq);
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		double pay = lRequest.getdPayment();
		if (pay<= 0.36*(lRequest.getIncome()/12) && pay <= 0.28*(lRequest.getIncome()/12 - lRequest.getExpenses())) {
			System.out.format("%.2f", pay);
		}
		
		
	}
}
