package Model;

public class Netlink {
	private int Customer_ID; 
	private String Customer_Name;
	private int BroadBand, LandLine;

	public Netlink() {
		super();
	}

	public Netlink(int customer_ID, String customer_Name, int broadBand, int landLine) {
		super();
		Customer_ID = customer_ID;
		Customer_Name = customer_Name;
		BroadBand = broadBand;
		LandLine = landLine;
	}

	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public int getBroadBand() {
		return BroadBand;
	}

	public void setBroadBand(int broadBand) {
		BroadBand = broadBand;
	}

	public int getLandLine() {
		return LandLine;
	}

	public void setLandLine(int landLine) {
		LandLine = landLine;
	}
	
}
