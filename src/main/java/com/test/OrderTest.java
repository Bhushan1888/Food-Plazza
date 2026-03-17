package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.OrderDaoImpl;
import com.pojo.Order;

public class OrderTest {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OrderDaoImpl od=new OrderDaoImpl();
		String emailId;
		int choice;
		while(true) {
			System.out.println("**Order**");
			System.out.println("1.Place Order\n2.Show Order\n3.Exit");
			System.out.println("Enter Choice:");
			choice=sc.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter An Exiting EmailId:");
				emailId=br.readLine();
				Order o=od.placeOrder(emailId);
				if(o!=null) {
					System.out.println(o);
				}else {
					System.out.println("Failed");
				}
				break;

			case 2:
				System.out.println("Show Orders:");
				List<Order>l=od.showOrder();
				Iterator<Order>itr=l.iterator();
				while(itr.hasNext()) {
					System.out.println(itr.next());
				}

			}

		}

	}

}
