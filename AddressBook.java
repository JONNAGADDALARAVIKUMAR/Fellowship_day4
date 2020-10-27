package day4;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook extends ContactPerson
{

	public static void main(String[] args) 
	{
		
		int choice,yes =1, no=2, noOfContacts,mailPosition=7,PhNoPosition=6;
		String details = null;
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> AddressBook = new ArrayList<String>();
		
		System.out.print("\n\n\tWelcome to Addres Book Programme\n\nCreate an Address\n\n");

		for(noOfContacts=1;true;noOfContacts++) 
		{
			
			if(noOfContacts > no)//Works from 3rd iteration. i.e checks 2nd iteration details in third iteration and continues
			{
				for(String contactString : AddressBook)
				{
				
					String[] address = contactString.split("  ");
				
					if(details.contains(address[PhNoPosition]) || details.contains(address[mailPosition]))
					{
						System.out.println("Contact already exist");
						System.out.print("\n\nCreate Another Contact\n\t1.Yes\n\t2.No\n\nChoice : ");
						
						choice=scan.nextInt();
					
						if(choice == no)
							break;
					}
					else
					{
						AddressBook.add(details);

						System.out.print("\n\nContact Added Successfully\n\n\nCreate Another Contact\n\t1.Yes\n\t2.No\n\nChoice : ");
						choice=scan.nextInt();
					
						if(choice == no)
							break;
					}
				}
			}
			details = personDetails();//Takes data from first iteration
			
			//It adds details to the address book only once(first time)
			if(noOfContacts == yes)
			{
				AddressBook.add(details);
				details=null;
				System.out.print("\nContact Added Successfully\n\n\nCreate Another Contact\n\n\t1.Yes\n\t2.No\n\nChoice : ");
				
				choice=scan.nextInt();
				if(choice == no)
					break;
			}
		}
		System.out.println("\nAddress Book Closed");
	}
}

class ContactPerson {
	
	static String firstName, lastName, city, zip, email, phoneNumber, state, address;
	
	static Scanner scan = new Scanner(System.in);
 
	public static String personDetails()
	{
		
		System.out.print("\n\tFIRST NAME : ");
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
	
		return personDetails;
	}
}
