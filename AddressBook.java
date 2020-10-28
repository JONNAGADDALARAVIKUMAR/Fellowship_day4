package day4;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook extends ContactPerson
{
	static ArrayList<String> addressBook = new ArrayList<String>();


	public static void main(String[] args) 
	{
		
		int choice,noOfContacts,mailPosition=7,PhNoPosition=6,one=1,two=2;
		String details = null;
		final int editContact=2, exit=3;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\n\tWelcome to Addres Book Programme\n\nCreate an Address\n\n");

		for(noOfContacts=1;true;noOfContacts++) 
		{
			
			if(noOfContacts > two)//Works from 3rd iteration. i.e checks 2nd iteration details in third iteration and continues
			{
				for(String contactString : addressBook)
				{
				
					String[] address = contactString.split("  ");
				
					if(details.contains(address[PhNoPosition]) || details.contains(address[mailPosition]))
					{
						System.out.println("Contact already exist");
						System.out.print("\n\nCreate Another Contact\n\t1.Yes\n\t2.No\n\nChoice : ");
						
						choice=scan.nextInt();
					
						if(choice == exit)
							break;
					}
					else
					{
						addressBook.add(details);

						System.out.print("\n\nContact Added Successfully\n\n\n1.Create Another Contact\n\t2.Edit Contact\n\t2.Exit\n\nChoice : ");
						choice=scan.nextInt();
					
						switch (choice)
						{
						case editContact:
							editDetails();
							System.out.println("Edited Successfully");
							break;
						case exit:
							break;
						}
					}
				}
			}
			details = personDetails();//Takes data from first iteration
			
			//It adds details to the address book only once(first time)
			if(noOfContacts == one)
			{
				addressBook.add(details);
	
				System.out.print("\nContact Added Successfully\n\n\n1.Create Another Contact\n\n\t2.Edit contact\n\t3.Exit\n\nchoice : ");
				
				choice=scan.nextInt();
				switch (choice)
				{
				case editContact:
					
					for(String address : addressBook)
					{
						String[] contact = address.split("  ");
						
						System.out.println(contact[0]+","+contact[1]+","+contact[6]+","+contact[7]);
					}
					editDetails();
					System.out.println("Edited Successfully");
					break;
				case exit:
					break;
				}
			}
		}
	}
	
private static void editDetails() {
		
		System.out.print("Enter Mobile Number OR Email : ");
		editWith=scan.next();
		int i=0;
		for(String address : addressBook)
		{
			if(address.contains(editWith))
			{
				editedDetails=personDetails();//it gets updated address
				
				addressBook.set(i, editedDetails);//replaces the updated address
			}
			i++;
		}		
	}

	
}

class ContactPerson {
	
	static String firstName, lastName, city, zip, email, phoneNumber, state, address,editedDetails,editWith;
	
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
