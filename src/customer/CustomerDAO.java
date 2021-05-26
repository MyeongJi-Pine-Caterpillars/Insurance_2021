package customer;

import java.util.ArrayList;

public interface CustomerDAO {
	public boolean insert(Customer customer);
	public ArrayList<Customer> select();
	public boolean updatePassword(String customerId, String passowrd);
	public boolean updateName(String customerId, String name);
	public boolean updateAddress(String customerId, String address);
	public boolean updatePhoneNumber(String customerId, String phoneNumber);
	public boolean delete(String customerId);
}