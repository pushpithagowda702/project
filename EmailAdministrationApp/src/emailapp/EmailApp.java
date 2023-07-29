package emailapp;
import java.util.*;

public class EmailApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter company name: ");
        String companyName = sc.nextLine();
        System.out.print("1. Create Email\n2. Exit\nEnter your choice: ");
				int ch = sc.nextInt();
				switch (ch) {
          case 1:
            System.out.print("Enter first name: ");
  	        String firstName = sc.next();
            System.out.print("Enter last name: ");
				    String lastName = sc.next();
            Email em = new Email(firstName, lastName, companyName);
            break;
          case 2:
            System.out.println("Exiting the program.");
            sc.close(); // Close the scanner before exiting the program
            return;
          default:
            System.out.println("Invalid Input");
            break;
        }
    }
}