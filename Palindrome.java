/********************************************************************************************
 * File Name : PalindromeDriver.java

 * Author : Sreeram Pulavarthi

 * Date: 02-14-2018

 * Compiler Used: Java 1.8
 
 * Description of File: Splits the number received from user, checks if number is 
 * 						palindrome or not
 * 			
 * 						If not a palindrome find and retrieve the nearest palindrome.
 * 
 *  Methods: Checkit(), Fixit()  
 *  						
 * 
 *********************************************************************************************
 */

public class Palindrome {

	private String mainnumber;
	private int mainnumberInt;

	public Palindrome(String iNPVAL) {

		this.mainnumber = iNPVAL;

		this.mainnumberInt = Integer.parseInt(mainnumber);

		System.out.println("\nNumber Received is --> " + mainnumber);

		if ((mainnumberInt > 0) && (mainnumberInt < 1000000)) {
			if (mainnumberInt <= 11) {

				System.out.println("\n Nearest palindrome is 11 ");

			}

			else {

				if ((mainnumberInt % 11) <= 9) {

					Checkit(mainnumberInt, mainnumber);
				} else {
					Fixit(mainnumberInt, mainnumber);
				}

			}
		} else {
			System.out.println("\n<--Invalid Input-->");
		}
	}

	private void Checkit(int mainnumberInt2, String mainnumber2) {

		// Check if number is appropriate or not, if not call method fixit
		
		if (mainnumber2.length() % 2 == 0) {

			String[] vals = mainnumber2.split("");

			int mid = mainnumber2.length() / 2, cntr = 0;

			String[] First_half = new String[mid], Second_half = new String[mid];

			String Firr = null, Secc = null;

			for (int i = 0; i < mid; i++) {
				First_half[i] = vals[i];

			}
			for (int i = mid; i < mainnumber2.length(); i++) {
				Second_half[cntr] = vals[i];
				cntr++;

			}

			Firr = String.join("", First_half);
			Secc = String.join("", Second_half);

			if (Firr.equals(Secc))
				System.out.println("Its a Palindrome");
			else {
				Fixit(mainnumberInt2, mainnumber2);
			}

		} else {
			Fixit(mainnumberInt2, mainnumber2);
		}

	}

	private void Fixit(int mainnumberInt2, String mainnumber2) {

		// Fixes the number to next available palindrome
		
		if (mainnumber2.length() % 2 == 0) {

			/*********** INITIALIZE VALUES *************************************/

			String[] vals = mainnumber2.split("");

			int mid = mainnumber2.length() / 2, cntr = 0, cntr2 = 0;

			Integer[] First_half = new Integer[mid], Second_half = new Integer[mid];

			int cntr3 = mid - 1;

			String Final_numb = null;

			/************************ SPLITTING VALUES *******************************/

			for (int i = mid - 1; i >= 0; i--) {

				// System.out.println("\nValue = "+vals[i]);
				First_half[cntr2] = Integer.parseInt(vals[i]);

				cntr2++;

			}
			for (int i = mid; i < mainnumber2.length(); i++) {
				Second_half[cntr] = Integer.parseInt(vals[i]);
				cntr++;

			}

			/******************** LOGIC *************************************/

			for (int i = 0; i < mid; i++) {
				// if (i == 0) {
				if ((i == 0) && (Second_half[i] == 9) && (First_half[i] == 9)) {

					if (First_half[i + 1] < Second_half[i + 1]) {
						First_half[i + 1] = First_half[i + 1] + 1;
						First_half[i] = 0;
						Second_half[i] = 0;
					}

				}

				else if ((i == 0) && (Second_half[i] == First_half[i])) {

					if (First_half[i + 1] < Second_half[i + 1]) {
						First_half[i] = First_half[i] + 1;
						Second_half[i] = First_half[i];
					}

				}

				else if ((i == 0) && (First_half[i] < Second_half[i])) {
					First_half[i] = First_half[i] + 1;
					Second_half[i] = First_half[i];

				} else if ((i == 0) && (First_half[i] > Second_half[i])) {

					Second_half[i] = First_half[i];

				}

				Second_half[i] = First_half[i];
			}

			/****************** MERGE 2 HALF'S AND MAKE A SINGLE NUMBER ******************/

			for (int i = 0; i < mid; i++) {
				int j = i + mid;

				vals[i] = First_half[cntr3].toString();
				vals[j] = Second_half[i].toString();
				cntr3--;
			}
			Final_numb = String.join("", vals);

			System.out.println("\n\nNearest Palindrome = " + Final_numb);

		} else {

			/************************
			 * INITIALIZE VALUES FOR ODD LENGTH
			 ***********************/

			String[] vals = mainnumber2.split("");

			int mid = mainnumber2.length() / 2, cntr = 0, cntr2 = 0;

			Integer[] First_half = new Integer[mid], Second_half = new Integer[mid];

			Integer Pivot = 0;

			int cntr3 = mid - 1;

			String Final_numb = null;

			/**************** SPLITTING VALUES *************************************/

			for (int i = mid - 1; i >= 0; i--) {

				First_half[cntr2] = Integer.parseInt(vals[i]);

				cntr2++;

			}
			for (int i = mid + 1; i < mainnumber2.length(); i++) {
				Second_half[cntr] = Integer.parseInt(vals[i]);
				cntr++;

			}

			Pivot = Integer.parseInt(vals[mid]);

			/******************** ODD LOGIC **************************/

			for (int i = 0; i < mid; i++) {
				// if (i == 0) {
				if ((Pivot == 9) && (i == 0) && (Second_half[i] == 9) && (First_half[i] == 9)) {

					if (First_half[i + 1] < Second_half[i + 1]) {
						First_half[i + 1] = First_half[i + 1] + 1;
						First_half[i] = 0;
						Second_half[i] = 0;
						Pivot = 0;
					}

				}

				else if ((i == 0) && (Second_half[i] == First_half[i])) {

					if (First_half[i + 1] < Second_half[i + 1]) {
						First_half[i] = First_half[i] + 1;
						Second_half[i] = First_half[i];
					}

				}

				else if ((i == 0) && (First_half[i] < Second_half[i])) {

					if (Pivot == 9) {
						First_half[i] = First_half[i] + 1;
						Second_half[i] = First_half[i];
						Pivot = 0;
					} else {
						Second_half[i] = First_half[i];
						Pivot = Pivot + 1;
					}
				}

				else if ((i == 0) && (First_half[i] > Second_half[i])) {

					Second_half[i] = First_half[i];
				}

				Second_half[i] = First_half[i];
			}

			/****************** MERGE 2 HALF'S AND MAKE A SINGLE NUMBER ******************/

			for (int i = 0; i < mid; i++) {
				int j = i + mid + 1;

				vals[i] = First_half[cntr3].toString();
				vals[j] = Second_half[i].toString();

				cntr3--;
			}

			vals[mid] = Pivot.toString();
			Final_numb = String.join("", vals);

			System.out.println("\n\nNearest Palindrome = " + Final_numb);
		}
	}

}
