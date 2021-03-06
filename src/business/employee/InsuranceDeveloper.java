package business.employee;

import business.insurance.ActualCostInsurance;
import business.insurance.CancerInsurance;
import business.insurance.DentalInsurance;
import business.insurance.DriverInsurance;
import business.insurance.FireInsurance;
import business.insurance.Insurance;
import business.insurance.TripInsurance;
import db.dao.InsuranceDAO;
import global.Constants.eInsuranceType;

public class InsuranceDeveloper extends Employee {
	private InsuranceDAO insuranceDAO;
	
	public InsuranceDeveloper(InsuranceDAO insuranceDAO){
		this.insuranceDAO = insuranceDAO;
	}

	public Insurance designInsurance(Insurance insurance, int type){
		switch (type) {
		case 1:
			insurance = new DriverInsurance();
			insurance.setType(eInsuranceType.driverInsurance);
			break;
		case 2:
			insurance = new DentalInsurance();
			insurance.setType(eInsuranceType.dentalInsurance);
			break;
		case 3:
			insurance = new ActualCostInsurance();
			insurance.setType(eInsuranceType.actualCostInsurance);
			break;
		case 4:
			insurance = new FireInsurance();
			insurance.setType(eInsuranceType.fireInsurance);
			break;
		case 5:
			insurance = new CancerInsurance();
			insurance.setType(eInsuranceType.cancerInsurance);
			break;
		case 6:
			insurance = new TripInsurance();
			insurance.setType(eInsuranceType.tripInsurance);
			break;
		}
		return insurance;
		
	}

	public boolean postManageInsurance(Insurance insurance, boolean del){
		return insuranceDAO.updateDel(insurance.getInsuranceId(), del);
	}

	public void readSurveyResult(){

	}

	public Insurance setDetailOfInsurance(Insurance insurance, String type, double[] rate){
		switch(type) {
		case "age":
			insurance.setRateOfAge(rate);
			break;
		case "gender":
			insurance.setRateOfGender(rate);
			break;
		case "job":
			insurance.setRateOfJob(rate);
			break;
		}
		return insurance;
	}
	
	public boolean finishInsurance(Insurance insurance) {
		return this.insuranceDAO.insert(insurance);
	}
}