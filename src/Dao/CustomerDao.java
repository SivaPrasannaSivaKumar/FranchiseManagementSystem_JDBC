package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Customer;
import Utility.ConnectionManager;

public class CustomerDao extends GetConnection{
	Connection dbConn = null;

	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}
	
	/////////////STORE CUSTOMER///////////////////
	public void StoreCustomerRecord(ArrayList<Customer> custList) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String INSERT = "INSERT INTO Customer(Customer_ID, Customer_Name, Customer_PhoneNumber, Customer_Address) values (?, ?, ?, ?)";
		try {
			PreparedStatement  ps = dbConn.prepareStatement(INSERT);
			for(Customer customer:custList) {
				ps.setInt(1, customer.getCustomerID());
				ps.setString(2, customer.getCustomerName());
				ps.setString(3, customer.getCustomerPhNO());
				ps.setString(4, customer.getCustomerAddress());
				int result = ps.executeUpdate();
				if(result == 1) {
					System.out.println("Rows Affected : " + result);
					System.out.println("😄👍 Customer record added successfully\n");
				}
			}
		} catch (SQLException e) {
			System.out.println("😕 Failed to add customer record\n");
		} 	
	}

	//////////////VIEW CUSTOMER////////////////////
	public void ViewCustomer() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String VIEW = "SELECT * FROM Customer";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(VIEW);
			System.out.println("=========================================================================================================================");
			System.out.println("Customer_ID			Customer_Name			Customer_PhoneNumber			Customer_Address");
			System.out.println("=========================================================================================================================");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "				" + rs.getString(2) + "				" + rs.getString(3) + "				" + rs.getString(4));
			}
			System.out.println("=========================================================================================================================");
		} catch (SQLException e) {
			System.out.println("😕 Failed to view customer record\n");
		}
	}
	
	////////////UPDATE CUSTOMER///////////////////
	public void UpdateCustomer(int update, int updateCustomerID, String newCustomerDetail) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String UPDATE = null;
		if(update == 1)
			UPDATE = "UPDATE Customer SET Customer_Name = ? WHERE Customer_ID = ?";
		else if(update == 2)
			UPDATE = "UPDATE Customer SET Customer_PhoneNumber = ? WHERE Customer_ID = ?";
		else if(update == 3)
			UPDATE = "UPDATE Customer SET Customer_Address = ? WHERE Customer_ID = ?";
		try {
			PreparedStatement ps = dbConn.prepareStatement(UPDATE);
			ps.setString(1, newCustomerDetail);
			ps.setInt(2, updateCustomerID);
			int result = ps.executeUpdate();
			if(result == 1) {
				System.out.println("Rows Affected : " + result);
				System.out.println("😄👍 Customer record updated successfully\n");
			}
		} catch (SQLException e) {
			System.out.println("😕 Failed to update customer record\n");
		}
	}

	public void DeleteCustomer(int deleteCustomerID) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String DELETE = "DELETE FROM Customer WHERE Customer_ID = " + deleteCustomerID;
		try {
			Statement stmt = dbConn.createStatement();
			int RowAffected = stmt.executeUpdate(DELETE);
			System.out.println("Rows Affected : " + RowAffected);
			System.out.println("😄 Customer record deleted successfully");
		} catch (SQLException e) {
			System.out.println("Failed to delete customer record\n");
			e.printStackTrace();
		}
		
	}

	public void viewDetails() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String SHOWALL = "SELECT Customer.Customer_ID, Customer.Customer_Name, Customer.Customer_PhoneNumber, Customer.Customer_Address, Netlink.BroadBand, Netlink.LandLine FROM Customer LEFT JOIN Netlink ON Customer.Customer_ID = Netlink.Customer_ID";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(SHOWALL);
			System.out.println("=========================================================================================================================================================================================");
			System.out.println("Customer_ID			Customer_Name			Customer_PhoneNumber			Customer_Address			BroanBand			LandLine");
			System.out.println("=========================================================================================================================================================================================");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "				" + rs.getString(2) + "				" + rs.getString(3) + "				" + rs.getString(4) + "					" + rs.getString(5) + "				" + rs.getString(6));
			}
			System.out.println("=========================================================================================================================================================================================");
		} catch (SQLException e) {
			System.out.println("😕 Failed to view customer record\n");
		}
	}

 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
