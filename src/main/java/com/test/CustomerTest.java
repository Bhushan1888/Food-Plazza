package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.CustomerDaoImpl;
import com.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String cName,cEmailId,cPassword,cAddress,cContactNo;
		
		CustomerDaoImpl custObj = new CustomerDaoImpl();
		
		while(true)
		{
			System.out.println("1.add\n2.Update\n3.delete\n4.search\n5.showAllData");
			System.out.println("Enter the choice : ");
			int choice = sc.nextInt();
			
			boolean b;
			switch(choice)
			{
			case 1 : 
				
				System.out.println("How many data you want to add : ");
				int num = sc.nextInt();
				
				for(int i=1;i<=num;i++)
				{
					System.out.println("Enter the cName : ");
					cName = br.readLine();
					System.out.println("Enter the cEmailId : ");
					cEmailId = br.readLine();
					System.out.println("Enter the cPassword : ");
					cPassword = br.readLine();
					System.out.println("Enter the cAddress : ");
					cAddress = br.readLine();
					System.out.println("Enter the cContactNo : ");
					cContactNo = br.readLine();
					
					b = custObj.addCustomer(new Customer(cName,cEmailId,cPassword,cAddress,cContactNo));
					if(b)
					{
						System.out.println("Successfully");
					}
					else
					{
						System.out.println("Failed");
					}
				}
				break;
				
			case 2 :
				
				System.out.println("Enter the cName : ");
				cName = br.readLine();
				System.out.println("Enter the cPassword : ");
				cPassword = br.readLine();
				System.out.println("Enter the cAddress : ");
				cAddress = br.readLine();
				System.out.println("Enter the cContactNo : ");
				cContactNo = br.readLine();
				System.out.println("Enter the cEmailId : ");
				cEmailId = br.readLine();
				
				b = custObj.updateCustomerById(new Customer(cName,cEmailId,cPassword,cAddress,cContactNo));
				if(b)
				{
					System.out.println("Successfully");
				}
				else
				{
					System.out.println("Failed");
				}
				break;
				
			case 3 : 
				System.out.println("Enter the cEmailId for delete : ");
				cEmailId = br.readLine();
				
				b = custObj.deleteCustomerById(cEmailId);
				if(b)
				{
					System.out.println("Suscessfully");
				}
				else
				{
					System.out.println("Failed");
				}
				break;
				
			case 4 : 
				System.out.println("Enter the cEmailId for search : ");
				cEmailId = br.readLine();
				
				Customer cs = new Customer();
				cs = custObj.searchCustomerById(cEmailId);
				
				if(cs!=null)
				{
					System.out.println(cs);
				}
				else
				{
					System.out.println("Not available");
				}
//				if(b)
//				{
//					System.out.println("Suscessfully");
//				}
//				else
//				{
//					System.out.println("Failed");
//				}
				break;
				
			case 5 : 
				System.out.println("All records : ");
				List<Customer> l = custObj.getAllCustomer();
				
				Iterator<Customer> itr = l.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
				break;
			}
		}
	}
}
