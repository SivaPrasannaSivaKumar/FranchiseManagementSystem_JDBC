package Service;

import java.util.ArrayList;

import Dao.CustomerDao;
import Model.Customer;

public class CustomerDetails {
	CustomerDao CustDao = new CustomerDao();
	ArrayList<Customer> CustList = new ArrayList<>();
	public void AddCustomer(Customer customer) throws ClassNotFoundException {
		CustList.add(customer);
		CustDao.StoreCustomerRecord(CustList);
	}
}
