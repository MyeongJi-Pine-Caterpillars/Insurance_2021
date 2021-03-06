package db.dao;

import java.util.ArrayList;

import business.customer.Insurant;

public interface InsurantDAO {
	public boolean insert(Insurant insurant);
	public ArrayList<Insurant> select();
	public Insurant selectInsurant(String InsurantId);
	public Insurant selectByCustomerId(String customerId);
	public String selectCustomerId(String insurantId);
	
	public boolean updateName(String insurantId, String name);
	public boolean updateAddress(String insurantId, String address);
	public boolean updatePhoneNumber(String insurantId, String phoneNumber);
	public boolean updateAge(String insurantId, int age);
	public boolean updateAccidentHistory(String insurantId, int accidentHistory);
	public boolean updatePostedPriceOfStructure(String insurantId, long postedPriceOfStructure);
	
	public boolean updateUsageOfStructure(String insurantId, int usageOfStructure);
	public boolean updateGender(String insurantId, int gender);
	public boolean updateJob(String insurantId, int job);
	public boolean updateTypeOfCar(String insurantId, int typeOfCar);
	public boolean updateRankOfCar(String insurantId, int rankOfCar);
	public boolean updateRiskOfTripCountry(String insurantId, int riskOfTripCountry);
	public boolean updateForRecontract(Insurant insurant);
	
	public boolean delete(String insurantId);
	public boolean updateFamilyMedicalRelationship(String insurantId, int familyMedicalRelationship);
	public boolean updateFamilyMedicalDisease(String insurantId, int familyMedicalDisease);
		
		
}
