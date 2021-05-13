package main;

import java.util.ArrayList;
import java.util.Scanner;
import contract.AccidentList;
import contract.AccidentListImpl;
import contract.Contract;
import contract.ContractList;
import contract.ContractListImpl;
import customer.Customer;
import customer.CustomerList;
import customer.CustomerListImpl;
import customer.Insurant;
import employee.Employee;
import employee.EmployeeList;
import global.Constants.eEmployeeRole;
import global.Constants.eGender;
import global.Constants.eInsuranceType;
import global.Constants.eJob;
import global.Constants.eRankOfCar;
import global.Constants.eRiskOfTripCountry;
import global.Constants.eUsageOfStructure;
import insurance.ActualCostInsurance;
import insurance.CancerInsurance;
import insurance.DentalInsurance;
import insurance.DriverInsurance;
import insurance.FireInsurance;
import insurance.Insurance;
import insurance.InsuranceList;
import insurance.InsuranceListImpl;
import insurance.TripInsurance;

public class Home {
	private Scanner scn;

	private InsuranceList insuranceList;
	private ContractList contractList;
	private CustomerList customerList;
	private EmployeeList employeeList;
	
	public Home() {
		this.scn = new Scanner(System.in);
		this.insuranceList = new InsuranceListImpl();
		this.contractList = new ContractListImpl();
		this.customerList = new CustomerListImpl();
	}
	
	public void start() {
		while (true) {
			System.out.println("*******보험사 메뉴*******");
			System.out.println("1.고객");
			System.out.println("2.직원");
			System.out.println("0.시스템 종료");
			
			switch (scn.nextInt()) {
			case 1:
				customer : while (true) {
					System.out.println("*******고객 메뉴*******");
					System.out.println("1.로그인");
					System.out.println("2.회원가입");
					System.out.println("0.뒤로가기");
					try {
						switch (scn.nextInt()) {
						case 1:
							if (true) { // 여기에 로그인 함수가 들어가야함
								login: while (true) {
									System.out.println("1.전체 보험리스트 확인하기");
									System.out.println("2.고객 만족 설문조사 작성하기");
									System.out.println("3.가입한 보험 리스트 확인하기");
									System.out.println("4.면담 신청하기");
									System.out.println("0.로그아웃");
									switch (scn.nextInt()) {
									case 1:
										break;
									case 2:
										break;
									case 3:
										break;
									case 4:
										break;
									case 0:
										break login;
									default:
										break;
									}
								}
							}
							break;
						case 2:
							createCustomer();
							break;
						case 0:
							break customer;
						default:
							System.out.println("error : 범위 내의 숫자를 입력해주세요");
							System.out.println("------------------------------");
							break;
						}
					} catch (Exception e) {
						System.out.println("error : 숫자를 입력해주세요");
						System.out.println("-----------------------");
						scn.nextLine();
					}
				}
				break;
			case 2:
				employee: while (true) {
					System.out.println("*******직원 메뉴*******");
					System.out.println("1.로그인");
					System.out.println("2.회원가입");
					System.out.println("0.뒤로가기");
					try {
						switch (scn.nextInt()) {
						case 1:
							Employee employee = new Employee();
							if (true) { // 여기에 로그인 함수가 들어가야함
								switch (employee.getEmployeeRole()) {
								case insuranceDeveloper:
									System.out.println("*******보험개발자 메뉴*******");
									System.out.println("1.");
									System.out.println("2.");
									System.out.println("0.로그아웃");
									break;
								case insuranceConfirmer:
									System.out.println("*******보험상품 확정자 메뉴*******");
									System.out.println("1.");
									System.out.println("2.");
									System.out.println("0.로그아웃");
									break;
								case salesperson:
									System.out.println("*******영업사원 메뉴*******");
									System.out.println("1.");
									System.out.println("2.");
									System.out.println("0.로그아웃");
									break;
								case contractManager:
									System.out.println("*******계약관리자 메뉴*******");
									System.out.println("1.");
									System.out.println("2.");
									System.out.println("0.로그아웃");
									break;
								case compensationHandler:
									System.out.println("*******보상처리사 메뉴*******");
									System.out.println("1.");
									System.out.println("2.");
									System.out.println("0.로그아웃");
									break;
								case underWriter:
									System.out.println("*******U/W 메뉴*******");
									System.out.println("1.");
									System.out.println("2.");
									System.out.println("0.로그아웃");
									break;
								default:
									break;

								}
							}
							break;
						case 2:
							 createEmployee();
							break;
						case 0:
							break employee;
						default:
							System.out.println("error : 범위 내의 숫자를 입력해주세요");
							System.out.println("———————————————");
							break;
						}
					} catch (Exception e) {
						System.out.println("error : 숫자를 입력해주세요");
						System.out.println("———————————");
						scn.nextLine();
					}
				}
				break;
			case 0:
				System.out.println("시스템을 종료합니다");
				System.exit(0);
				break;
			}
		}
	}
	
	// 가입한 보험 리스트 보기
	private void showSubscribedInsurance() {
		Customer customer = this.selectCustomer();
		for (Contract contract : this.contractList.getContractList()) {
			if(contract.getCustomer().getCustomerId() == customer.getCustomerId()) {
				this.showInsuranceData(contract.getInsurance());
			}
		}

	}
	
	
	// 전체 보험 리스트 확인하기
	private void showAllInsurance() {
		eInsuranceType type = null;
		while (true) {
			System.out.println("1.운전자 보험\n2.치아 보험\n3.실비 보험\n4.화재 보험\n5.암 보험\n6.여행 보험\n7.전체보기");
			switch(scn.nextInt()) {
			case 1 :
				type = eInsuranceType.driverInsurance;
				break;
			case 2 :
				type = eInsuranceType.dentalInsurance;
				break;
			case 3 :
				type = eInsuranceType.actualCostInsurance;
				break;
			case 4 :
				type = eInsuranceType.fireInsurance;
				break;
			case 5 :
				type = eInsuranceType.cancerInsurance;
				break;
			case 6 :
				type = eInsuranceType.tripInsurance;
				break;
			case 7 :
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			break;
		}
		System.out.println("-----보험리스트-----");
		if(type == null) { //null이면 전체보험
			for (Insurance insurance: this.insuranceList.getInsuranceList()) {
				this.showInsuranceData(insurance);
			}
		} else {
			for (Insurance insurance: this.insuranceList.getInsuranceList()) {
				if(insurance.getType() == type) {
					this.showInsuranceData(insurance);
				}
			}
		}
		System.out.println("-----------------\\n");
	}
	
	// 보험 가입하기
	private void contractInsurnace() {
		Insurance insurance = null;
		System.out.print("가입할 보험 ID를 입력해주세요 : ");
		insurance = this.insuranceList.select(scn.next());
		if (insurance != null) {
			Customer customer = this.selectCustomer();
			Insurant insurant = this.selectInsurant(customer);
			if(customer != null) {
				Contract contract = new Contract();
				contract.joinInsurance(customer, insurance, insurant);
				this.contractList.insert(contract);
				System.out.print("!!!!보험가입이 완료되었습니다!!!!");
			}
		} else {
			System.out.print("해당 보험이 존재하지 않습니다");
		}
	}
	
	// 고객 선택
	private Customer selectCustomer() {
		Customer customer = null;
		while (customer == null) {
			System.out.print("가입할 고객 아이디를 입력해주세요 : ");
			String customerId = scn.next();
			customer = this.customerList.select(customerId);
			if(customer == null) {
				System.out.println("해당 고객이 존재하지 않습니다");
			}
		}
		return customer;
	}

	// 보험 가입자 선택하기
	private Insurant selectInsurant(Customer customer) {
		System.out.print("1.보험가입자 선택\n2.보험가입자 생성 : ");
		int input = scn.nextInt();
		while(input != 1 && input != 2) {
			System.out.println("잘못된 입력입니다");
			System.out.print("1.보험가입자 선택\n2.보험가입자 생성 : ");
			input = scn.nextInt();
		}
		if(input == 1 && !customer.getInsurantList().isEmpty()) {
			boolean flag = false;
			while(!flag) {
				System.out.print("보험가입자 ID를 입력하세요 : ");
				String InsurantId = scn.next();
				if(customer.getInsurantList().select(InsurantId) != null) {
					flag = true;
					createContract();
				} else {
					System.out.println("해당 보험가입자가 존재하지 않습니다");
				}
			}
		} else {
			this.createInsurant(customer);
		}
		return customer.getInsurantList().getSelectedInsurant();
	}

	private void createInsurant(Customer customer) {
		System.out.print("사고횟수 : ");
		int accidentHistory = scn.nextInt();
		System.out.print("주소 : ");
		String address = scn.next();
		System.out.print("나이 : ");
		int age = scn.nextInt();
		System.out.print("아이디 : ");
		String id = scn.next();
		System.out.print("이름 : ");
		String name = scn.next();
		System.out.print("전화번호 : ");
		String phoneNum = scn.next();
		System.out.print("건물가격 : ");
		long postedPriceOfStructure = scn.nextLong();
		System.out.print("건물용도\n1.집\n2.학원\n3.공장\n4.창고\n5.사무실\n6.공공시설");
		eUsageOfStructure usageOfStructure = null;
		while (usageOfStructure == null) {
			switch (scn.nextInt()) {
			default:
				System.out.print("입력값이 잘못되었습니다");
				break;
			case 1:
				usageOfStructure = eUsageOfStructure.house;
				break;
			case 2:
				usageOfStructure = eUsageOfStructure.study;
				break;
			case 3:
				usageOfStructure = eUsageOfStructure.factory;
				break;
			case 4:
				usageOfStructure = eUsageOfStructure.warehouse;
				break;
			case 5:
				usageOfStructure = eUsageOfStructure.office;
				break;
			case 6:
				usageOfStructure = eUsageOfStructure.publicFacility;
				break;
			}
		}
		System.out.println("성별\n1.남자\n2.여");
		eGender gender = null;
		while(gender == null) {
			switch(scn.nextInt()) {
				default :
					System.out.print("입력값이 잘못되었습니다");
					break;
				case 1 :
					gender = eGender.male;
					break;
				case 2 :
					gender = eGender.female;
					break;
			}
		}
		System.out.println("직업\n1.사무직\n2.운전자\n3.현장직\n4.학생\n5.교사\n6.군인\n7.기타");
		eJob job = null;
		while(job == null) {
			switch(scn.nextInt()) {
			default :
				System.out.print("입력값이 잘못되었습니다");
				break;
			case 1 :
				job = eJob.officeWorker;
				break;
			case 2 :
				job = eJob.driver;
				break;
			case 3 :
				job = eJob.factoryWorker;
				break;
			case 4 :
				job = eJob.student;
				break;
			case 5 :
				job = eJob.teacher;
				break;
			case 6 :
				job = eJob.soldier;
				break;
			case 7 :
				job = eJob.etc;
				break;
			}
		}
		System.out.println("자동차등급\n1.상\n2.중\n3.하");
		eRankOfCar rankOfCar = null;
		while(rankOfCar == null) {
			switch(scn.nextInt()) {
			default :
				System.out.print("입력값이 잘못되었습니다");
				break;
			case 1 :
				rankOfCar = eRankOfCar.high;
				break;
			case 2 :
				rankOfCar = eRankOfCar.middle;
				break;
			case 3 :
				rankOfCar = eRankOfCar.low;
				break;
			}
		}
		System.out.println("여행국가 위험등급\n1.안전\n2.1등급\n3.2등급\n4.3등급");
		eRiskOfTripCountry riskOfTripCountry = null;
		while(riskOfTripCountry == null) {
			switch(scn.nextInt()) {
			default :
				System.out.print("입력값이 잘못되었습니다");
				break;
			case 1 :
				riskOfTripCountry = eRiskOfTripCountry.safe;
				break;
			case 2 :
				riskOfTripCountry = eRiskOfTripCountry.first;
				break;
			case 3 :
				riskOfTripCountry = eRiskOfTripCountry.second;
				break;
			case 4 :
				riskOfTripCountry = eRiskOfTripCountry.third;
				break;
			}
		}
		customer.createInsurant(accidentHistory, address, age, id, name, phoneNum, postedPriceOfStructure, usageOfStructure, gender, job, rankOfCar, riskOfTripCountry);
		customer.getInsurantList().select(id);
	}
	
	
	private void createContract() {
		
	}
	// 고객 가입하기
	private void createCustomer() {
		Customer customer = new Customer();
		System.out.println("이름을 입력해주세요.");
		customer.setName(scn.next());
		
		System.out.println("주소를 입력해주세요.");
		customer.setAddress(scn.next());
		
		System.out.println("전화번호를 입력해주세요.(ooo-oooo-oooo)");
		customer.setPhoneNumber(scn.next());
		
		while(true) {
			System.out.println("사용하실 ID를 입력해주세요.(중복확인)");
			String input = scn.next();
			if(customerList.checkDuplication(input)) {
				customer.setCustomerId(input);
				break;
			} else {
				System.out.println("이미 존재하는 ID입니다!(사용불가)");
				System.out.println("--------------------------");
			}
		}

		System.out.println("비밀번호를 입력해주세요.");
		customer.setPassword(scn.next());
		
		if(customerList.insert(customer)) {
			System.out.println("!!!회원가입이 완료되었습니다!!!!");
		}
	}
	// 고객 로그인하기
//	private boolean loginCustomer(String id, String pw) {
//		for(Customer customer : this.customerList.getCustomerList()) {
//			if(customer.getCustomerId().equals(id)) {
//				if(customer.getPassword().equals(pw)) {
//					return true;
//				}else {
//					System.out.println("error : 비밀번호가 틀립니다!");
//					return false;
//				}
//			}
//		}
//		System.out.println("error : 존재하지 않는 ID입니다!");
//		return false;
//	}
	
	// 직원 가입하기
	private void createEmployee() {
		Employee employee = new Employee();
		System.out.println("이름을 입력해주세요.");
		employee.setName(scn.next());
		
		System.out.println("전화번호를 입력해주세요.(ooo-oooo-oooo)");
		employee.setPhoneNumber(scn.next());

		role : while (true) {
			System.out.println("직종을 선택해주세요.");
			System.out.println("1.보험개발자");
			System.out.println("2.보험상품 확정자");
			System.out.println("3.영업사원");
			System.out.println("4.계약관리인");
			System.out.println("5.보상처리사");
			System.out.println("6.U/W");
			try {
				switch (scn.nextInt()) {
				case 1:
					employee.setEmployeeRole(eEmployeeRole.insuranceDeveloper);
					break role;
				case 2:
					employee.setEmployeeRole(eEmployeeRole.insuranceConfirmer);
					break role;
				case 3:
					employee.setEmployeeRole(eEmployeeRole.salesperson);
					break role;
				case 4:
					employee.setEmployeeRole(eEmployeeRole.contractManager);
					break role;
				case 5:
					employee.setEmployeeRole(eEmployeeRole.compensationHandler);
					break role;
				case 6:
					employee.setEmployeeRole(eEmployeeRole.underWriter);
					break role;
				default:
					System.out.println("error : 범위 내의 숫자를 입력해주세요");
					System.out.println("------------------------------");
					break;
				}
			} catch (Exception e) {
				System.out.println("error : 숫자를 입력해주세요");
				System.out.println("-----------------------");
				scn.nextLine();
			}
		}
		
		while(true) {
			System.out.println("사용하실 ID를 입력해주세요.(중복확인)");
			String input = scn.next();
			if(employeeList.checkDuplication(input)) {
				employee.setEmployeeId(input);
				break;
			} else {
				System.out.println("이미 존재하는 ID입니다!(사용불가)");
				System.out.println("--------------------------");
			}
		}

		System.out.println("비밀번호를 입력해주세요.");
		employee.setPassword(scn.next());

		if (employeeList.insert(employee)) {
			System.out.println("!!!회원가입이 완료되었습니다!!!!");
		}
	}

	// 고객 로그인하기
//	private boolean loginEmployee(String id, String pw) {
//		for (Customer customer : this.customerList.getCustomerList()) {
//			if (customer.getCustomerId().equals(id)) {
//				if (customer.getPassword().equals(pw)) {
//					return true;
//				} else {
//					System.out.println("error : 비밀번호가 틀립니다!");
//					return false;
//				}
//			}
//		}
//		System.out.println("error : 존재하지 않는 ID입니다!");
//		return false;
//	}

	// 보험 만들기
	private void createInsurance() {
		Insurance insurance;
		while (true) {
			System.out.println("1.운전자 보험\n2.치아 보험\n3.실비 보험\n4.화재 보험\n5.암 보험\n6.여행 보험\n7.돌아가기");
			System.out.printf("어떤 보험을 기획하시겠습니까? : ");
			switch (scn.nextInt()) {
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
			case 7:
				System.out.println("메인 메뉴로 돌아갑니다");
				return;
			default:
				insurance = null;
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				continue;
			}
			
			insurance = this.createPlanInsurance(insurance);	// 보험 설계하기
			if (insurance == null) {
				continue;
			}
			insurance = this.createDetailInsurance(insurance);	// 보험 세부설정하기
			
			if (this.insuranceList.insert(insurance)) {
				System.out.println("!!!보험 설계가 완료되었습니다!!!!");
			} else {
				System.out.println("보험 설계에 실패하였습니다. 다시 시도해주세요.");
				continue;
			}
		}
	}
	
	// 보험 설계하기
	private Insurance createPlanInsurance(Insurance newInsurance) {
		while (true) {
			System.out.println("1.남자\n2.여자\n0.돌아가기");
			System.out.printf("가입 제한 성별을 입력하세요 : ");
			int inputGender = scn.nextInt();
			if (inputGender == 1) {
				newInsurance.setDeniedGender(eGender.male);
			} else if (inputGender == 2) {
				newInsurance.setDeniedGender(eGender.female);
			} else if (inputGender == 0) {
				System.out.println("이전 화면으로 돌아갑니다.");
				return null;
			}
			
			System.out.printf("동일한 조건의 보험들을 확인하시겠습니까?(y/n) : ");
			String inputCondition = scn.next();
			if (inputCondition.equals("y")) {
				for (Insurance insurance: this.insuranceList.getInsuranceList()) {
					if ((insurance.getType() != newInsurance.getType()) && (insurance.getDeniedGender() == newInsurance.getDeniedGender())) {
						continue;
					}
					this.showInsuranceData(insurance);
				}
				
				System.out.printf("적용을 원하는 보험의 ID를 입력하세요 : ");
				String inputIndex = scn.next();
				boolean isExist = false;
				for (Insurance insurance: this.insuranceList.getInsuranceList()) {
					if (inputIndex.equals(insurance.getInsuranceId())) {
						isExist = true;
					}
				}
				if (isExist) {
					newInsurance.setRateOfAge(this.insuranceList.getInsuranceList().get(Integer.parseInt(inputIndex)).getRateOfAge());
					newInsurance.setRateOfGender(this.insuranceList.getInsuranceList().get(Integer.parseInt(inputIndex)).getRateOfGender());
					newInsurance.setRateOfJob(this.insuranceList.getInsuranceList().get(Integer.parseInt(inputIndex)).getRateOfJob());
					System.out.println("선택한 보험의 요율정보로 설정했습니다. 세부설정 단계로 넘어갑니다.");
					return newInsurance;
				} else {
					System.out.println("존재하지 않는 ID입니다. 기획 화면으로 돌아갑니다.");
					continue;
				}
			} else if (inputCondition.equals("n")) {
				System.out.println("보험 설계가 완료되었습니다. 세부설정 단계로 넘어갑니다.");
				return newInsurance;
			} else {
				System.out.println("잘못 입력하셨습니다. 기획 화면으로 돌아갑니다.");
				continue;
			}
		}
	}
	
	// 보험 세부설정하기
	private Insurance createDetailInsurance(Insurance newInsurance) {
		while (true) {
			System.out.println("나이에 대한 요율을 설정합니다. ex) 20대 : 1.0)");
			double[] tmpRateOfAge = new double[7];
			System.out.println("  <나이 요율표>");
			System.out.printf("영유아 : ");
			tmpRateOfAge[0] = scn.nextDouble();
			System.out.printf("10대 : ");
			tmpRateOfAge[1] = scn.nextDouble();
			System.out.printf("20대 : ");
			tmpRateOfAge[2] = scn.nextDouble();
			System.out.printf("30대 : ");
			tmpRateOfAge[3] = scn.nextDouble();
			System.out.printf("40대 : ");
			tmpRateOfAge[4] = scn.nextDouble();
			System.out.printf("50대 : ");
			tmpRateOfAge[5] = scn.nextDouble();
			System.out.printf("노년층 : ");
			tmpRateOfAge[6] = scn.nextDouble();
			newInsurance.setRateOfAge(tmpRateOfAge);
			System.out.println("나이에 대한 요율설정을 완료했습니다.");
			break;
		}
		while (true) {
			System.out.println("성별에 대한 요율을 설정합니다. ex) 남자 : 1.0)");
			double[] tmpRateOfGender = new double[2];
			System.out.printf("\n  <성별 요율표>");
			System.out.printf("남자 : ");
			tmpRateOfGender[0] = scn.nextDouble();
			System.out.printf("여자 : ");
			tmpRateOfGender[1] = scn.nextDouble();
			double[] tmpRateOfJob = new double[7];
			System.out.printf("\n  <직업 요율표>");
			System.out.printf("직장인 : ");
			tmpRateOfJob[0] = scn.nextDouble();
			System.out.printf("운전기사 : ");
			tmpRateOfJob[1] = scn.nextDouble();
			System.out.printf("공장노동직 : ");
			tmpRateOfJob[2] = scn.nextDouble();
			System.out.println("학생 : ");
			tmpRateOfJob[3] = scn.nextDouble();
			System.out.printf("교사(수) : ");
			tmpRateOfJob[4] = scn.nextDouble();
			System.out.printf("군인 : ");
			tmpRateOfJob[5] = scn.nextDouble();
			System.out.printf("기타직업 : ");
			tmpRateOfJob[6] = scn.nextDouble();
			newInsurance.setRateOfGender(tmpRateOfGender);
			newInsurance.setRateOfJob(tmpRateOfJob);
			System.out.println("성별과 직업에 대한 요율설정을 완료했습니다.");
			break;
		}
		while (true) {
			// 보장 내역 설정하기 코딩해야함
			break;
		}
		return newInsurance;
	}
	
	// 보험 확정하기
	private void confirmInsurance() {
		while (true) {
			System.out.printf("보험 확정하기를 진행하시겠습니까?(y/n) : ");
			String inputProgress = scn.next();
			if (inputProgress.equals("y")) {
				for (Insurance insurance: this.insuranceList.getInsuranceList()) {
					if (insurance.isConfirmedStatus()) {
						continue;
					}
					this.showInsuranceData(insurance);
					
				}
				System.out.printf("확정을 원하는 보험의 ID를 입력하세요 : ");
				String inputIndex = scn.next();
				boolean isExist = false;
				for (Insurance insurance: this.insuranceList.getInsuranceList()) {
					if (inputIndex.equals(insurance.getInsuranceId())) {
						isExist = true;
					}
				}
				if (isExist && this.insuranceList.getInsuranceList().get(Integer.parseInt(inputIndex)).isConfirmedStatus()) {
					System.out.println("이미 확정된 보험입니다. 다시 선택해주세요.");
					continue;
				} else if(isExist && !this.insuranceList.getInsuranceList().get(Integer.parseInt(inputIndex)).isConfirmedStatus()) {
					this.insuranceList.getInsuranceList().get(Integer.parseInt(inputIndex)).setConfirmedStatus(true);
					System.out.println("선택한 보험이 확정되었습니다!!!");
					continue;
				}
				else {
					System.out.println("존재하지 않는 ID입니다. 다시 선택해주세요.");
					continue;
				}
			} else if (inputProgress.equals("n")) {
				System.out.println("이전 화면으로 돌아갑니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
		}
	}
	
	// 보험 정보 출력하기
	private void showInsuranceData(Insurance insurance) {
		System.out.println(insurance.getInsuranceId()+". "+insurance.getName());
		System.out.println("  기본보험료 : "+insurance.getBasicFee());
		System.out.println("  <나이 요율표>");
		System.out.println("영유아 : "+insurance.getRateOfAge()[0]);
		System.out.println("10대 : "+insurance.getRateOfAge()[1]);
		System.out.println("20대 : "+insurance.getRateOfAge()[2]);
		System.out.println("30대 : "+insurance.getRateOfAge()[3]);
		System.out.println("40대 : "+insurance.getRateOfAge()[4]);
		System.out.println("50대 : "+insurance.getRateOfAge()[5]);
		System.out.println("노년층 : "+insurance.getRateOfAge()[6]);
		System.out.println("\n  <성별 요율표>");
		System.out.println("남자 : "+insurance.getRateOfGender()[0]);
		System.out.println("여자 : "+insurance.getRateOfGender()[1]);
		System.out.println("\n  <직업 요율표>");
		System.out.println("직장인 : "+insurance.getRateOfJob()[0]);
		System.out.println("운전기사 : "+insurance.getRateOfJob()[1]);
		System.out.println("공장노동직 : "+insurance.getRateOfJob()[2]);
		System.out.println("학생 : "+insurance.getRateOfJob()[3]);
		System.out.println("교사(수) : "+insurance.getRateOfJob()[4]);
		System.out.println("군인 : "+insurance.getRateOfJob()[5]);
		System.out.println("기타직업 : "+insurance.getRateOfJob()[6]);
		System.out.println("-----------------\n");
		
		// 보장내역 조회하는 것 코딩해야함
	}
}
