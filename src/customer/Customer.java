package customer;

import java.util.ArrayList;

import insurace.InsuranceListImpl;

public class Customer {
	// Attributes
	private String address;
	private String customerId;
	private String name;
	private String phoneNumber;
	
	// Composition Class
	private InsurantList insurantList;
	// private Contract contract;
	// private Salesperson m_Salesperson;

	// Constructor
	public Customer(String address, String customerId, String name, String phoneNumber){
		this.address = address;
		this.customerId = customerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.insurantList = (InsurantList) new InsuranceListImpl();
	}
	
	// getters & setters
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	public String getCustomerId() {return customerId;}
	public void setCustomerId(String customerId) {this.customerId = customerId;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
	
	public InsurantList getInsurantList() {return insurantList;}
	public void setInsurantList(InsurantList insurantList) {this.insurantList = insurantList;}

	// Methods
	public void checkJoinedInsuranceList(){

	}

	public void checkPaymentHistory(){

	}

	public void checkWholeInsuranceList(){

	}

	public void requestInterview(){

	}

	public void writeSurvey(){

	}
}