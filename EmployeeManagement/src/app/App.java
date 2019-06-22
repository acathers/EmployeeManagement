package app;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Scanner;

// Ok, so you had a List of Employees inside of your Employee class which is a bit odd, We use the Employee class to simply represent one Employee
// So we're going to use this class as our Controller, (even though it has our display as well), so we're going to have all of our lists that might be used else where in here
public class App { // Controller class

    private List<Person> staff = new ArrayList<>(); // It's usually better to program to the interface so we can
                                                          // be more interchangeable. There are very few methods in
                                                          // arraylist that are special, and you'll probably never use
                                                          // them
    private Scanner input = new Scanner(System.in); // because I didn't feel like passing it around, probably would be
                                                    // better to, but since i'm instantiating the class it looks better
                                                    // here

    public static void main(String[] args) {
        new App().run();// to run the program
    }

    public void run() {
        
        displayMenu();// menu

        switch (getChoice()) { // The Switch for main stuff

        case 1:
        while(true){
            displayAdminMenu();
            handleAdminChoice(getChoice());
        }
            // why inserty choice =getChoice why not just getChocie()? i might still
            // thinking i don't want to have this all in one huge clump, so I might pass the
            // choice to a method
        case 2:
            break;
        case 3:
            break;
        case 4:
            break; //
        case 5:
            System.exit(0);
            break;
        default:
            System.out.println("Invalid option, try again");
        }
    }

    public int getChoice() {
        System.out.print("Selection: ");
        int value;
        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.print("Invalid input, try again: ");
        }
        value = input.nextInt(); // initalized here before return
        return value;
    }

    public void displayMenu() {
        System.out.println("Please Choice one of the following options\n" + "1. Admin\n" + "2. Employer\n"
                + "3. Customer\n" + "4. Apply for a job\n" + "5. Quit");
    }

    public void displayAdminMenu() {
        System.out.println("Please Choice one of the following options\n" + "1. Add Admin\n" + "2. Remove Admin\n"
                + "3. Display Admins\n" + "4. LogOut");
    }

    public void handleAdminChoice(int choice) {
        switch (choice) {
        case 1:
            try {
                staff.add(new Employee.EmployeeBuilder().setAge(3).setCountry("United States").setID("1")
                        .setName("Someone").setPassword("1234").setType(UserType.ADMIN).build());
            } catch (InvalidPropertiesFormatException e) {
                System.err.println(e);
            }
            break;
        case 2: 
            displayAdmins();
            System.out.println("Enter admin iD to remove");
            input.nextLine();
            String iD = input.nextLine();
            staff.remove(staff.stream().filter(s -> s.getiD().equals(iD)).findFirst().get());


        case 3://still didnt study the stream libery and ->
            displayAdmins();
        }
    }

    public void displayAdmins(){
        staff.stream().filter(Person::isAdmin).forEach(System.out::println);
    }
}