package global;

import insurance.*;

public class Constants {
	
	public static enum eAge {
		kids(1, "영유아"),
		teen(2, "10대"),
		twenties(3, "20대"),
		thirties(4, "30대"),
		fourties(5, "40대"),
		fifties(6, "50대"),
		older(7, "노년층");

		final private int num;
		final private String name;
		
		private eAge(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}
	}
	
	public static enum eAccidentType {
		driver(1),
		dental(2),
		actual(3),
		fire(4),
		cancer(5),
		trip(6);
		
		final private int num;
		
		private eAccidentType(int num) {
			this.num = num;
		}

		public int getNum() {return num;}
	}

	public static enum eGender {
		male(1, "남성"),
		female(2, "여성"),
		both(3, "남성/여성");

		final private int num;
		final private String name;
		
		private eGender(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}
	}

	public static enum eJob {
		officeWorker(1, "사무직"),
		driver(2, "운송업"),
		factoryWorker(3, "현장직"),
		student(4, "학생"),
		teacher(5, "교육직"),
		soldier(6, "군인"),
		etc(7, "기타");

		final private int num;
		final private String name;
		
		private eJob(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {return num;}
		public String getName() {return this.name;}
	}

	public static enum eRankOfCar {
		high(1), middle(2), low(3);

		final private int num;
		
		private eRankOfCar(int num) {
			this.num = num;
		}

		public int getNum() {return num;}
	}

	public static enum eUsageOfStructure {
		house(1), study(2), factory(3), warehouse(4), office(5), publicFacility(6);
		
		final private int num;
		
		private eUsageOfStructure(int num) {
			this.num = num;
		}

		public int getNum() {return num;}
	}

	public static enum eRiskOfTripCountry {
		safe(1), first(2), second(3), third(4);

		final private int num;
		
		private eRiskOfTripCountry(int num) {
			this.num = num;
		}

		public int getNum() {return num;}
		
	}

	public static enum eGuaranteePlanGuaranteeItem {

	}
	
	private static String[] driverGuarantee = {"대인", "대물"};
	private static String[] dentalGuarantee = {"레진", "크라운", "틀니", "임플란트", "스케일링", "발치"};
	private static String[] actualCostGuarantee = {"실비보험"};
	private static String[] fireGuarantee = {"화재", "수해", "도난손해", "상해후유장애", "고장수리"};
	private static String[] cancerGuarantee = {"감상선암", "고환암", "난소람", "식도암", "폐암", "간암", "위암", "췌장암"};
	private static String[] tripGuarantee = {"사망", "상해", "해외의료비", "휴대품손해", "배상책임", "항공기납치"};

	public enum eInsuranceType {
		driverInsurance(1, new DriverInsurance(), "driverInsurance", driverGuarantee),
		dentalInsurance(2, new DentalInsurance(), "dentalInsurance", dentalGuarantee),
		actualCostInsurance(3, new ActualCostInsurance(), "actualCostInsurance", actualCostGuarantee),
		fireInsurance(4, new FireInsurance(), "fireInsurance", fireGuarantee),
		cancerInsurance(5, new CancerInsurance(), "cancerInsurance", cancerGuarantee),
		tripInsurance(6, new TripInsurance(), "tripInsurance", tripGuarantee);

		private int num;
		private Insurance selectedInsurance;
		private String name;
		private String[] guaranteePlan;
		
		private eInsuranceType(int num, Insurance selectedInsurance, String name, String[] guaranteePlan) {
			this.num = num;
			this.selectedInsurance = selectedInsurance;
			this.name = name;
			this.guaranteePlan = guaranteePlan;
		}

		public int getNum() {return this.num;}
		public Insurance getSelectedInsurance() {return this.selectedInsurance;}
		public String getName() {return this.name;}
		public String[] getGuaranteePlan() {return guaranteePlan;}		
	}

	public static enum eFamilyMedicalDisease {
		thyroid, testicular, ovarian, esophageal, lung;
	}

	public static enum eEmployeeRole {
		insuranceDeveloper(1), insuranceConfirmer(2), salesperson(3), contractManager(4), compensationHandler(5), underWriter(6);
		
		final private int num;
		
		private eEmployeeRole(int num) {
			this.num = num;
		}

		public int getNum() {return num;}
	}
}
