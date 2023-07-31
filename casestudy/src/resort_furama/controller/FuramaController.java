package resort_furama.controller;

import resort_furama.service.customer.CustomerService;
import resort_furama.service.customer.ICustomerService;
import resort_furama.service.employee.EmployeeService;
import resort_furama.service.employee.IEmployeeService;
import resort_furama.service.facility.FacilityService;
import resort_furama.service.facility.IFacilityService;

import java.util.Scanner;

public class FuramaController {
    private static IEmployeeService employeeService = new EmployeeService();
    private static ICustomerService customerService = new CustomerService();

    private static IFacilityService facilityService = new FacilityService();

    public static void displayMenu() {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.println("--------MENU----------");
                System.out.println("1.Employee Management");
                System.out.println("2.Customer Management");
                System.out.println("3.Facility Management");
                System.out.println("4.Booking Management");
                System.out.println("5.Promotion");
                System.out.println("6.Exit");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        employeeManagement();
                        break;
                    case 2:
                        customerManagement();
                        break;
                    case 3:
                        facilityManagement();
                        break;
                    case 4:
                        bookingManagement();
                        break;
                    case 5:
                        promotionManagement();
                        break;
                    case 6:
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number key");
            }
        } while (true);
    }

    public static void employeeManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.println("---------EMPLOYEE MANAGEMENT---------");
                System.out.println("1. Display list employee");
                System.out.println("2. Add new employee");
                System.out.println("3. Edit employee");
                System.out.println("4. Delete employee");
                System.out.println("5. Search by name employee");
                System.out.println("6. Return main menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        employeeService.displayAll();
                        break;
                    case 2:
                        employeeService.addEmployee();
                        break;
                    case 3:
                        employeeService.editEmployee();
                        break;
                    case 4:
                        employeeService.deleteEmployee();
                        break;
                    case 5:
                        employeeService.searchByName();
                        break;
                    case 6:
                        displayMenu();

                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number key");
            }
        } while (true);
    }

    public static void customerManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.println("-------CUSTOMER MANAGEMENT------");
                System.out.println("1. Display list customers");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Delete customer");
                System.out.println("5. Search by name customer");
                System.out.println("6. Return main menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        customerService.displayListCustomer();
                        break;
                    case 2:
                        customerService.addNewCustomer();
                        break;
                    case 3:
                        customerService.editCustomer();
                        break;
                    case 4:
                        customerService.deleteCustomer();
                        break;
                    case 5:
                        customerService.searchByNameCustomer();
                        break;
                    case 6:
                        displayMenu();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number key");
            }

        } while (true);

    }

    public static void facilityManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.println("------FACILITY MANAGER-----");
                System.out.println("1. Display list facility");
                System.out.println("2. Add new facility");
                System.out.println("3. Display list facility maintenance");
                System.out.println("4. Delete facility");
                System.out.println("5  Return main menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        facilityService.displayFacility();
                        break;
                    case 2:

                    case 3:
                        facilityService.displayListMaintenance();
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number key");
            }
        } while (true);
    }

    public static void bookingManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.println("-------BOOKING MANAGEMENT------");
                System.out.println("1. Add new booking");
                System.out.println("2. Display list booking");
                System.out.println("3. Create list contracts");
                System.out.println("4. Display list contracts");
                System.out.println("5. Edit contracts");
                System.out.println("6. Return main menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {

                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number key");
            }
        } while (true);

    }

    public static void promotionManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.println("----------PROMOTION MANAGEMENT--------");
                System.out.println("1. Display list customers use service");
                System.out.println("2. Display list customers get voucher");
                System.out.println("3. Return main menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {

                }
            } catch (NumberFormatException e) {
                System.out.println("Please a number key");
            }
        } while (true);
    }

}
