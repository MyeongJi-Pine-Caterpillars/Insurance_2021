package customer;

import java.util.ArrayList;

public interface CustomerList {
	
	// Methods
	public boolean insert(Customer customer);
	public Customer select(String customerId);
	public boolean delete(String customerId);
	public void updateNameById(String customerId, String data);
	public boolean checkDuplication(String input);
	
	// Getters & Setters
	public ArrayList<Customer> getCustomerList();
	public void setCustomerList(ArrayList<Customer> customerList);
}