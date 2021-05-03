package insurace;

public class Insurance {

	// Attributes
	private int basicFee;
	private boolean confirmedStatus;
	private String insuranceId;
	private String name;
	private float[] rateOfAge; // index[0 : ������/ 1 : 10��/ 2 : 20��/ 3 : 30��/ 4 : 40��/ 5 : 50��/ 6 : �����]
	private float[] rateOfGender; // index[0 : ����/ 1 : ����]
	private float[] rateOfJob; // index[0 : ������/ 1 : �������/ 2 : ���� �뵿��/ 3 : �л�/ 4 : ����(��)��/ 5 : ����/ 6 : ��Ÿ]
	private int specialContractFee;
	private enum type{};
	private int warrantyPeriod;
	
	// Composition Class
	public membershipCondition m_membershipCondition;
	public GuaranteePlan m_GuaranteePlan;

	// Constructor
	public Insurance(){

	}
	
	// getters & setters
	public int getBasicFee() {return basicFee;}
	public void setBasicFee(int basicFee) {this.basicFee = basicFee;}

	public boolean isConfirmedStatus() {return confirmedStatus;}
	public void setConfirmedStatus(boolean confirmedStatus) {this.confirmedStatus = confirmedStatus;}

	public String getInsuranceId() {return insuranceId;}
	public void setInsuranceId(String insuranceId) {this.insuranceId = insuranceId;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public float[] getRateOfAge() {return rateOfAge;}
	public void setRateOfAge(float[] rateOfAge) {this.rateOfAge = rateOfAge;}

	public float[] getRateOfGender() {return rateOfGender;}
	public void setRateOfGender(float[] rateOfGender) {this.rateOfGender = rateOfGender;}

	public float[] getRateOfJob() {return rateOfJob;}
	public void setRateOfJob(float[] rateOfJob) {this.rateOfJob = rateOfJob;}
	
	public int getSpecialContractFee() {return specialContractFee;}
	public void setSpecialContractFee(int specialContractFee) {this.specialContractFee = specialContractFee;}

	public int getWarrantyPeriod() {return warrantyPeriod;}
	public void setWarrantyPeriod(int warrantyPeriod) {this.warrantyPeriod = warrantyPeriod;}

	public membershipCondition getM_membershipCondition() {return m_membershipCondition;}
	public void setM_membershipCondition(membershipCondition m_membershipCondition) {this.m_membershipCondition = m_membershipCondition;}

	public GuaranteePlan getM_GuaranteePlan() {return m_GuaranteePlan;}
	public void setM_GuaranteePlan(GuaranteePlan m_GuaranteePlan) {this.m_GuaranteePlan = m_GuaranteePlan;}
	
	public void finalize() throws Throwable {
	}
	
	// Methods
	public int calculateFee(int insurantId){
		return 0;
	}

}