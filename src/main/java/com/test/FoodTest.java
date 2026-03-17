package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.FoodDaoImpl;
import com.pojo.Food;

public class FoodTest {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int foodId,fQuantity; String fName,fType; float fPrice;

		FoodDaoImpl foodObj = new FoodDaoImpl();

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
					System.out.println("Enter the foodId : ");
					foodId = sc.nextInt();
					System.out.println("Enter the food name : ");
					fName = br.readLine();
					System.out.println("Enter the food type : ");
					fType = br.readLine();
					System.out.println("Enter the food quantity : ");
					fQuantity = sc.nextInt();
					System.out.println("Enter the food price : ");
					fPrice = sc.nextFloat();

					b = foodObj.addFood(new Food(fName,fType,fQuantity,fPrice));

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

				System.out.println("Enter the food id : ");
				foodId = sc.nextInt();
				System.out.println("Enter the food name : ");
				fName = br.readLine();
				System.out.println("Enter the food type : ");
				fType = br.readLine();
				System.out.println("Enter the food quantity : ");
				fQuantity = sc.nextInt();
				System.out.println("Enter the food price : ");
				fPrice = sc.nextFloat();

				b = foodObj.updateFoodById(new Food(fName,fType,fQuantity,fPrice));

				if(b)
				{
					System.out.println("Update successfully");
				}
				else
				{
					System.out.println("Failed");
				}
				break;

			case 3 :

				System.out.println("Enter the foodId foe delete : ");
				foodId = sc.nextInt();

				b = foodObj.deleteFoodById(foodId);

				if(b)
				{
					System.out.println("Successfully deleted");
				}
				else
				{
					System.out.println("Failed");
				}
				break;

			case  4 : 

				System.out.println("Enter the foodId for search : ");
				foodId = sc.nextInt();

				Food food = new Food();
				food = foodObj.searchFoodById(foodId);

				if(food!=null)
				{
					System.out.println(food);
				}
				else
				{
					System.out.println("Not available");
				}
				break;

			case 5 : 
				System.out.println("Show All data");

				List<Food> l = new ArrayList<Food>();
				l = foodObj.getAllFood();

				Iterator<Food>it=l.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;

			}
		}

	}
}
