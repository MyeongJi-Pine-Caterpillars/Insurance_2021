package main;
import customer.Customer;
import customer.CustomerListImpl;

public class Main {

	public static void main(String[] args) {
		CustomerListImpl customerList = new CustomerListImpl();
		customerList.insert(new Customer("���Ϸ�38", "5kso3", "���ö", "01071300465"));
		System.out.println(customerList.select("5kso3").getName());
		customerList.updateNameById("5kso3", "�����");
		System.out.println(customerList.delete("5kso3"));
		System.out.println(customerList.delete("5kso3"));
	}
}
