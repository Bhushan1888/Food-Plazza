package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.CartDaoImpl;
import com.pojo.Cart;

public class CartTest {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cartId,foodId,fQuantity;
		String emailId,foodName;
		float price,totalPrice;

		CartDaoImpl cartObj = new CartDaoImpl();
		
		while(true)
		{
			System.out.println("1.Add cart\n2.Show cart\n3.Delete cart\n4.Clear cart");
			System.out.println("Enter the choice : ");
			int choice = sc.nextInt();
			boolean b;
			
			switch(choice)
			{
			case 1 :
				System.out.println("How many data you want to add : ");
				int count = sc.nextInt();
				
				for(int i=1;i<=count;i++)
				{
					System.out.println("Enter the cart id : ");
					cartId = sc.nextInt();
					System.out.println("Enter the food id : ");
					foodId = sc.nextInt();
					System.out.println("Enter the quantity : ");
					fQuantity = sc.nextInt();
					System.out.println("Enter the email id ");
					emailId = br.readLine();
					System.out.println("Enter the food name : ");
					foodName = br.readLine();
					System.out.println("Enter the price : ");
					price = sc.nextFloat();
					totalPrice= price*fQuantity;
					
					b = cartObj.addcart(new Cart(cartId,fQuantity,emailId,foodName,price,totalPrice));
					if(b)
					{
						System.out.println("Successfully added");
					}
					else
					{
						System.out.println("Failed");
					}
				}
				break;
				
			case 2 :
				System.out.println("Enter existing emailId : ");
				emailId = br.readLine();
				List<Cart> l = cartObj.Showcart(emailId);
				Iterator<Cart> itr = l.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
				break;
				
			case 3 :
				System.out.println("Enter existing cartid : ");
				cartId = sc.nextInt();
				b = cartObj.deleteCart(cartId);
				
				if(b)
				{
					System.out.println("Delete successfully");
				}
				else
				{
					System.out.println("failed");
				}
				break;
				
			case 4 :
				System.out.println("Enter the existing emailId : ");
				emailId = br.readLine();
				b = cartObj.clearCart(emailId);
				
				if(b)
				{
					System.out.println("Clear successfully.");
				}
				else
				{
					System.out.println("failed");
				}
				break;
			}
		}
	}

}
