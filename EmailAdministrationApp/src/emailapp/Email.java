package emailapp;
import java.util.*;

public class Email {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int defaultPasswordLength = 8;
	private String department;
	private int mailboxCapacity;
	private String alternateEmail;
	private String companyName;
	
	
	// Constructor to receive firstName and lastName
	public Email(String firstName, String lastName, String companyName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created: " + this.firstName + " " + this.lastName);
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		// Generate Email in firstName.lastName@department.companyName.com
		this.companyName = companyName;
		this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + this.companyName.toLowerCase();
		System.out.println("Your email is: " + this.email);
		// Set password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
	}
	
	// Get the details of the department
	private String setDepartment() {
		System.out.print("Department Codes \n1. Sales \n2. Accounting \n3. Marketing \n4. Development \n0. None \nEnter Department Code: ");
		Scanner sc = new Scanner(System.in);
		int depChoice = sc.nextInt();
		sc.close();
		switch (depChoice) {
			case 1: return "Sales";
			case 2: return "Accounting";
			case 3: return "Marketing";
			case 4: return "Development";
			case 0: return "";
			default: return "";
		}
	}
	
	// Generate random password;
	private String randomPassword(int length) {
		String setPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random() * setPassword.length());
			password[i] = setPassword.charAt(rand);
		}
		return new String(password);
	}
	
	// Set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set alternate email
	public void setAlternateEmail(String altMail) {
		this.alternateEmail = altMail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateMail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "Display Name: " + firstName + " " + lastName + 
				"Company Email: " + email +
				"Mailbox Capacity: " + mailboxCapacity + "mb";
	}
}
