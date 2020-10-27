package day4;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	
	static String firstName, lastName, city, zip, email, phoneNumber, state, address;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<String>();

		
		System.out.print("\n\n\tWelcome to Addres Book Programme\n\nCreate an Address\n\n\tFIRST NAME : ");
		
		firstName=scan.next();
		
		System.out.print("\n\tLAST NAME : ");
		lastName=scan.next();
		
		System.out.print("\n\tADDRESS : ");
		address=scan.next();
		
		System.out.print("\n\tCITY : ");
		city=scan.next();
		
		System.out.print("\n\tSTATE : ");
		state=scan.next();
		
		System.out.print("\n\tZIP : ");
		zip=scan.next();
		
		System.out.print("\n\tPHONE NUMBER : ");
		phoneNumber=scan.next();
		System.out.print("\n\tEMAIL : ");
		email=scan.next();
		
		String personDetails = "First Name\t:\t"+firstName+"  Last Name\t:\t"+lastName+"  Address\t\t:\t"+address+"  City\t\t:\t"+city+"  State\t\t:\t"+state+"  Zip\t\t:\t"+zip+"  Phone Number\t:\t"+phoneNumber+"  EMail\t\t:\t"+email;
		
		list.add(personDetails);
		
		for(String str1 : list)
		{
			
			String[] addr = str1.split("  ");
			for( String names : addr)
			System.out.println("\n"+names);
			
		}
		
	}

}
