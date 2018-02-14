/********************************************************************************************
 * File Name : PalindromeDriver.java

 * Author : Sreeram Pulavarthi

 * Date: 02-14-2018

 * Compiler Used: Java 1.8
 
 * Description of File: Splits input from user , creates the main class object for each 
 * 						number received
 *********************************************************************************************
 */

import java.util.Scanner;

public class PalindromeDriver {
	
	Scanner in = new Scanner(System.in);
	String input;
	int numbofintegs;
	
	Integer[] ACTVALS = {};
	
	String[] INPVAL = {};
	
	
	public void readData() {
		
		System.out.println("Enter all numbers here with space delimeted --> ");
		
		input=in.nextLine();
		
		INPVAL = input.split(" ");
		
		numbofintegs = Integer.parseInt(INPVAL[0]);
		
		for (int i=1;i<=numbofintegs;i++)
		{
			Palindrome PL = new Palindrome(INPVAL[i]);
		}
		
	}
	
	public static void main(String args[]) {
		
		PalindromeDriver PDR = new PalindromeDriver();
		
		PDR.readData();
	}
	
}
