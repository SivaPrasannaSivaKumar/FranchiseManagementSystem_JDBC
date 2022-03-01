package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Netlink;
import Utility.ConnectionManager;

public class NetlinkDao extends GetConnection {
	Connection dbConn = null;


	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}

	public void storeNetRecord(ArrayList<Netlink> netList) throws ClassNotFoundException {	
		dbConn = getDbConnection();
		String INSERT = "INSERT INTO Netlink (Customer_ID, Customer_Name, BroadBand, LandLine) values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = dbConn.prepareStatement(INSERT);
			for(Netlink netlink:netList) {
				ps.setInt(1, netlink.getCustomer_ID());
				ps.setString(2, netlink.getCustomer_Name());
				ps.setInt(3, netlink.getBroadBand());
				ps.setInt(4, netlink.getLandLine());
				int result = ps.executeUpdate();
				if(result == 1) {
					System.out.println("Rows Affected : " + result);
					System.out.println("😄👍 Netlink record added successfully");
				}
			}
		} catch (SQLException e) {
			System.out.println("😕 Failed to add customer record\n");
		}
	}

	public void ViewNetlinkCustomer() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String VIEW = "SELECT * FROM Netlink";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(VIEW);
			System.out.println("========================================================================================================");
			System.out.println("Customer_ID			Customer_Name			BroadBand			LandLine");
			System.out.println("========================================================================================================");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "				" + rs.getString(2) + "				" +  rs.getInt(3) + "				" + rs.getInt(4));
			}
			System.out.println("========================================================================================================");
		} catch (SQLException e) {
			System.out.println("😕 Failed to view customer record\n");
		}
	}
}
