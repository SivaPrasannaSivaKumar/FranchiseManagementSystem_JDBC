package Controller;

import java.util.Scanner;

import Dao.CustomerDao;
import Dao.NetlinkDao;
import Model.Customer;
import Model.Netlink;
import Service.CustomerDetails;
import Service.NetlinkDetails;

public class MainController {

	public static void main(String[] args) throws ClassNotFoundException {
		CustomerDetails cd = new CustomerDetails();
		NetlinkDetails nd = new NetlinkDetails();
		CustomerDao CustDao = new CustomerDao();
		NetlinkDao NetDao = new NetlinkDao();
		System.out.println("====================================================");
		System.out.println("	👨‍💼 FRANCHISE MANAGEMENT SYSTEM		");
		System.out.println("====================================================");
		boolean Login = true;
		while(Login) {
			System.out.println("\n1)Log in \n2)Log out \n");
			Scanner sc = new Scanner(System.in);
			System.out.print("Your Choice : ");
			int option = Integer.parseInt(sc.nextLine());
			switch(option) {
			case 1:{
				//////////Log in////////////
				System.out.print("\nUser : ");
				String Admin = sc.nextLine();
				System.out.print("Password : ");
				String AdminPwd = sc.nextLine();
				if(Admin.equals("Siva") && AdminPwd.equals("1234")) {
					System.out.println("\n🤩 Successfully Logged In.");
					boolean temp = true;
					while(temp) {
						System.out.println("\n👉 Choose any one operation to be performed : ");
						System.out.println("\n   1) Add Customer \n   2) View Customer \n   3) Update Customer \n   4) Delete Customer \n   5) Exit");
						boolean flag = true;
						int operation = 0;
						while(flag) {
							try {
								System.out.print("\n Your Choice : ");
								operation = Integer.parseInt(sc.nextLine());
								flag = false;
							} catch (Exception e) {
								System.out.println("Enter correct number\n");
								flag = true;
							}
						}
						
						switch(operation) {
						/////////ADD CUSTOMERS////////////
						case 1:{
								System.out.print("\n📝 How may customers that you need to add : ");
								int CustCount = Integer.parseInt(sc.nextLine());
								int CustID = 0, bB = 0, lL = 0;
								String CustName, CustPhNO, CustAddress;
								for(int i = 0; i < CustCount; i++) {
									boolean id = true;
									System.out.println(" 👉 Customer Details");
									while(id) {
										try {
											System.out.print("	Customer ID : ");
											CustID = Integer.parseInt(sc.nextLine());
											id = false;
										} catch (NumberFormatException e) {
											System.out.println("Enter correct number\n");
											id = true;
										}
									}
									
									System.out.print("	Customer Name : ");
									CustName = sc.nextLine();
									System.out.print("	Customer Phone Number : ");
									CustPhNO = sc.nextLine();
									System.out.print("	Customer Address : ");
									CustAddress = sc.nextLine();
									Customer customer = new Customer(CustID, CustName, CustPhNO, CustAddress);
									System.out.println("\n 👉 Customer Netlink Details");
									System.out.print("	Broadband : ");
									bB = Integer.parseInt(sc.nextLine());
									System.out.print("	Landline : ");
									lL = Integer.parseInt(sc.nextLine());
									Netlink netlink = new Netlink(CustID,CustName, bB, lL);
									cd.AddCustomer(customer);
									nd.AddNetlink(netlink);
								}
								break;
							}
						///////////VIEW CUSTOMER////////////
						case 2:{
								System.out.print("\n📝 What you want to view\n");
								System.out.print("\n   1)View Customer Details \n   2)View Customer Netlink Details \n   3)ViewAllDetails \n");
								System.out.print("\n	 Your Choice : ");
								int show = Integer.parseInt(sc.nextLine());
								if(show == 1)
									CustDao.ViewCustomer();
								else if(show == 2)
									NetDao.ViewNetlinkCustomer();
								else if (show == 3)
									CustDao.viewDetails();
								break;
							}
						//////////UPDATE CUSTOMER///////////
						case 3:{
								System.out.print("\nEnter CustomerID to update the record : ");
								int UpdateCustomerID = Integer.parseInt(sc.nextLine());
								boolean flag1 = true;
								System.out.print("\n📝 Select any one of the detail to get updated");
								try {
									while(flag1) {
										System.out.println("\n   1)Customer Name \n   2)Customer PhoneNumber \n   3)Customer Address \n   4)Exit");
										int Update = Integer.parseInt(sc.nextLine());
										switch(Update) {
										case 1:{
												System.out.print("\nEnter new Customer Name to be updated : ");
												String newCustomerName = sc.nextLine();
												CustDao.UpdateCustomer(Update, UpdateCustomerID, newCustomerName);
												break;
											}
										case 2:{
												System.out.print("\nEnter new Customer PhoneNumber to be updated : ");
												String newCustomerPhNO = sc.nextLine();
												CustDao.UpdateCustomer(Update, UpdateCustomerID, newCustomerPhNO);
												break;
											}
										case 3:{
												System.out.print("\nEnter new Customer Address to be updates : ");
												String newCustomerAddress = sc.nextLine();
												CustDao.UpdateCustomer(Update, UpdateCustomerID, newCustomerAddress);
												break;
											}
										case 4:{
												flag1 = false;
												break;
											}
										}
									}
								} catch (NumberFormatException e) {
									System.out.println("Enter correct number\n");
									flag1 = true;
								} 
							break;
						}
						/////////DELETE CUSTOMER////////////
						case 4:{
								System.out.print("\nEnter the CustomerID to delete the record : ");
								int DeleteCustomerID = 0;
								boolean flag2 = true;
								while(flag2) {
									try {
										DeleteCustomerID = Integer.parseInt(sc.nextLine());
										flag2 = false;
									} catch (NumberFormatException e) {
										System.out.println("Enter correct number\n");
										flag2 = true;
									}
								}
								CustDao.DeleteCustomer(DeleteCustomerID);
								break;
							}
						//////////////EXIT////////////////
						case 5:{
								temp = false;
								break;
							}
						}
					}
				}
				///////////INCORRECT USERNAME & PASSWORD////////////
				else {
					System.out.println("\n😕 Failed to log in. Incorrect Username or Password");
				}
				break;
			}
			///////////////////LOG OUT//////////////////////////
			case 2:{
					System.out.println("\n🤩Succeessfully Logged Out.");
					Login = false;
					break;
				}
			}
			sc.close();
		}
	}

}
