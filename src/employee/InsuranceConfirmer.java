package employee;

import insurance.Insurance;

public class InsuranceConfirmer {

	public Insurance m_Insurance;

	public InsuranceConfirmer(){

	}

	public void finalize() throws Throwable {

	}

	public void confirmInsurance(Insurance insurance){
		insurance.setConfirmedStatus(true);
	}

}