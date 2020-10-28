package day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook extends ContactPerson
{
	static ArrayList<String> addressBook = new ArrayList<String>();


	public static void main(String[] args) 
	{
		
		
		int choice,noOfContacts,mailPosition=7,PhNoPosition=6,one=1,two=2;
		String details = null,addressBookName;
		final int editContact=2, exit=4,deleteContact=3,newAddressBook=5;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\n\tWelcome to Addres Book Programme");

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
						System.out.println("Create new Contact");
						addressBook.add(details);

						System.out.print("\n\nContact Added Successfully\n\n\n\t1.Create Another Contact\n\t2.Edit Contact\n\t3.Delete Contact\n\t4.Exit\n\t5.new Address Book\n\nChoice : ");
						choice=scan.nextInt();
					
						switch (choice)
						{
						case editContact:
							editDetails();
							System.out.println("Edited Successfully");
							break;
						case deleteContact://Case to delete contact
							for(String address2 : addressBook)
							{
								String[] contact = address2.split("  ");
								
								System.out.println(contact[0]+","+contact[1]+","+contact[6]+","+contact[7]);
							}
							deleteContact();//Delete method calling
							System.out.println("Deleted Successfully");
							break;
						case newAddressBook:
						{
							System.out.print("Give a Name for the Current Address Book : ");
							addressBookName=scan.next();
							Book book = new Book(addressBookName,addressBook);
						}
						case exit:
							break;
						}
					}
				}
			}
			System.out.println("\n\n\tCreate new Contact");
			details = personDetails();//Takes data from first iteration
			
			//It adds details to the address book only once(first time)
			if(noOfContacts == one)
			{
				addressBook.add(details);
	
				System.out.print("\nContact Added Successfully\n\n\t1.Create Another Contact\n\t2.Edit contact\n\t3.Delete Contact\n\t4.Exit\n\t5.new Address Book\n\nchoice : ");
				
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
					
				case deleteContact:
					for(String address : addressBook)
					{
						String[] contact = address.split("  ");
						
						System.out.println(contact[0]+","+contact[1]+","+contact[6]+","+contact[7]);
					}
					deleteContact();
					System.out.println("Deleted Successfully");
					break;
					
				case newAddressBook:
				{
					System.out.print("Give a Name for the Current Address Book : ");
					addressBookName=scan.next();
					Book book = new Book(addressBookName,addressBook);//Class stores multiple Address books 
				}
					
				case exit:
					break;
				}
			}
		}
	}
	
private static void deleteContact() {
	
	System.out.print("Enter Mobile Number OR Email : ");
	String deleteWith=scan.next();
	
	int i=0;
	for(String address : addressBook)
	{
		if(address.contains(deleteWith))
		{
			
			addressBook.remove(i);//Deletes The contact
		}
		i++;
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
				editedDetails=personDetails();//it gets updated contact
				
				addressBook.set(i, editedDetails);//replaces the updated contact
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
class Book {
	
	HashMap<String,String> book = new HashMap<String,String>();
	
	public Book(String addressBookName, ArrayList<String> addressBook) {
		
		String addressBookStr=addressBook.toString();
		book.put(addressBookName, addressBookStr);
		
	}
}
