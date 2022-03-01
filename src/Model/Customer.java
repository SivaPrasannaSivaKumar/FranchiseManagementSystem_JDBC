package Model;

public class Customer {
	private int CustomerID;
	private String CustomerName, CustomerPhNO, CustomerAddress;
	public Customer() {
		super();
	}
	public Customer(int customerID, String customerName, String customerPhNO, String customerAddress) {
		super();
		CustomerID = customerID;
		CustomerName = customerName;
		CustomerPhNO = customerPhNO;
		CustomerAddress = customerAddress;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerPhNO() {
		return CustomerPhNO;
	}
	public void setCustomerPhNO(String customerPhNO) {
		CustomerPhNO = customerPhNO;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
}
