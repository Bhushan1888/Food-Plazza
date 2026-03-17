package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dao.AdminDaoImpl;

public class AdminTest {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		AdminDaoImpl adObj = new AdminDaoImpl();
		
		String emailId,password;
		
		System.out.println("1.UserLogin\n2.UserchangePasword\n3.AdminLogin\n4.AdminchnagePassword");
		
		System.out.println("Enter the choice : ");
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1 :
			System.out.println("Enter the email Id : ");
			emailId = br.readLine();
			System.out.println("Enter the password : ");
			password = br.readLine();
			
			boolean b1 = adObj.userLogin(emailId, password);
			if(b1)
			{
				System.out.println("Login successfully");
			}
			else
			{
				System.out.println("Login failed");
			}
			break;
			
		case 2 : 
			System.out.println("Enter the existing emailId : ");
			emailId = br.readLine();
			System.out.println("Enter the new password : ");
			password = br.readLine();
			
			boolean b2 = adObj.userchangepassword(emailId, password);
			if(b2)
			{
				System.out.println("Change password successfully");
			}
			else
			{
				System.out.println("Invalid email id");
			}
			break;
			
		case 3 : 
			System.out.println("Enter the email id : ");
			emailId = br.readLine();
			System.out.println("Enter the password : ");
			password = br.readLine();
			
			boolean b3 = adObj.adminLogin(emailId, password);
			if(b3)
			{
				System.out.println("Login successfully");
			}
			else
			{
				System.out.println("Login failed");
			}
			break;
			
		case 4 : 
			System.out.println("Enter the email id :");
			emailId = br.readLine();
			System.out.println("Enter the new password : ");
			password = br.readLine();
			
			boolean b4 = adObj.adminchangepassword(emailId, password);
			if(b4)
			{
				System.out.println("Change password successfully");
			}
			else
			{
				System.out.println("Invalid email id.");
			}
			break;
		}
	}
}
