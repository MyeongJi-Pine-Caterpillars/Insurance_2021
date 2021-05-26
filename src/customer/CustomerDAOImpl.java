package customer;

import java.sql.SQLException;
import java.util.ArrayList;

import main.DBConnector;

public class CustomerDAOImpl extends DBConnector implements CustomerDAO{
	public boolean insert(Customer customer) {
		String str = "INSERT INTO customer(name, address, phoneNumber, customerId, password) values('"
				+ customer.getName() + "','" + customer.getAddress() + "','" + customer.getPhoneNumber() + "','"
				+ customer.getCustomerId() + "','" + customer.getPassword() + "')";
		if (this.execute(str))
			return true;
		else
			return false;
	}

	public ArrayList<Customer> select() {
		ArrayList<Customer> arrayList = new ArrayList<Customer>();
		InsurantDAO insurantDAO = new InsurantDAOImpl();
		String sql = "SELECT * FROM customer";
		this.read(sql);
		try {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setPhoneNumber(rs.getString("phoneNumber"));
				customer.setCustomerId(rs.getString("customerId"));
				customer.setPassword(rs.getString("password"));
				customer.setInsurantList(insurantDAO.select());
				
				arrayList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public boolean updatePassword(String customerId, String password) {
		String str = "UPDATE customer set password = " + password + " WHERE CustomerId = " + customerId;
		if(this.execute(str)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateName(String customerId, String name) {
		String str = "UPDATE customer set name = " + name + " WHERE CustomerId = " + customerId;
		if(this.execute(str)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateAddress(String customerId, String address) {
		String str = "UPDATE customer set address = " + address + " WHERE CustomerId = " + customerId;
		if(this.execute(str)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePhoneNumber(String customerId, String phoneNumber) {
		String str = "UPDATE customer set phoneNumber = " + phoneNumber + " WHERE CustomerId = " + customerId;
		if(this.execute(str)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean delete(String customerId) {
		String str = "DELETE FROM customer WHERE CustomerId = " + customerId;
		if(this.execute(str)) {
			return true;
		} else {
			return false;
		}
	}
}