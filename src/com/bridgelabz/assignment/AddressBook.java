package com.bridgelabz.assignment;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
	
	static HashMap<String,ArrayList<ArrayList<String>>> addressbook = new  HashMap<String,ArrayList<ArrayList<String>>>();
    static String[] address = {"AddressBookOne","AddressBookTwo","AddressBookThree"};
    
    /*
     * This method is used to enter the information of a person
     * like first name,last name,address,city,zip,state,mobile no,and email id
     */
    public static  ArrayList<String> enterInform(ArrayList<String> names)
    {
    	ArrayList<String> personInfo = new ArrayList<String>();
	     Scanner sc = new Scanner(System.in);
	     
		System.out.println("Enter your First name :");
		String fname =sc.nextLine();
		personInfo.add(fname);
		names.add(fname);
		System.out.println("Enter your Last name : ");
		personInfo.add(sc.nextLine());
		System.out.println("Enter your address :");
		personInfo.add(sc.nextLine());
		System.out.println("Enter your city :");
		personInfo.add(sc.nextLine());
		System.out.println("Enter your state :");
		personInfo.add(sc.nextLine());
		System.out.println("Enter your zip :");
		personInfo.add(sc.nextLine());
		System.out.println("Enter your phoneno :");
		personInfo.add(sc.nextLine());
		System.out.println("Enter your email id :");
		personInfo.add(sc.nextLine());
	
		return personInfo;
		
	}
    /*
	 * This method first check the person's information is present or not,
	 * if not then add the person's information to the addressBook. 
	 */
    public static void addAndCheck(int n) {
    	
        for(int i=0;i<address.length;i++) {
        System.out.println("Enter into  :"+address[i]);
        
        ArrayList<ArrayList<String>> contacts =new ArrayList<ArrayList<String>>();
        ArrayList<String> names=new ArrayList<String>();
        
        for(int j=0;j<n;j++) {		
        		ArrayList<String> person= enterInform(names);
        		List<String> result = names
                        .stream()
                        .filter(x -> x.contains(person.get(0)))
                        .collect(Collectors.toList());
        		if(result.size()>1) {
        			System.out.println("Name is already exists");
        			j--;
        		}
        		else {
        		contacts.add(person);
        		}
        	}
        	addressbook.put(address[i], contacts);
        }
        System.out.println(addressbook);
    }
	
    
    /*
     * This is the main method to manipulate all the methods
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of person'information in one address  :");
        int n=scan.nextInt();
        

		/*
		 * Calling this method to check duplicate and adding to the address book
		 */
		addAndCheck(n);
		
    
    
	}

}
