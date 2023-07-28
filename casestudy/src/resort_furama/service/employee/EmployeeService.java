package resort_furama.service.employee;

import resort_furama.model.person.Employee;
import resort_furama.repository.employee.EmployeeRepository;
import resort_furama.repository.employee.IEmployeeRepository;
import resort_furama.until.Regex;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class EmployeeService implements IEmployeeService {

    private IEmployeeRepository repository = new EmployeeRepository();

    @Override
    public void displayAll() {
        List<Employee> employeeList = repository.displayAll();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String IDCard;
        String phoneNumber;
        LocalDate date;
        int salary;
        try {
            do {
                System.out.println("Enter a id ");
                id = scanner.nextLine();
                if (!id.matches(Regex.REGEX_ID_EMPLOYEE)) {
                    System.err.println("No valid,please enter again (NV-XXXX)");
                }
            } while (!id.matches(Regex.REGEX_ID_EMPLOYEE));
            do {
                System.out.println("Enter a name:");
                name = scanner.nextLine();
                if (!name.matches(Regex.REGEX_NAME)) {
                    System.err.println("No valid, please enter again, The first letter of the name must be capitalized");
                }
            } while (!name.matches(Regex.REGEX_NAME));
            do {
                System.out.println("Enter a date of birth(Year-Month-Day)");
                date = LocalDate.parse(scanner.nextLine());
                if ((LocalDate.now().compareTo(date) < 18)) {
                    System.err.println("You are not 18+, please enter again");
                }
            } while ((LocalDate.now().compareTo(date) < 18));
            System.out.println("Enter a gender");
            String gender = scanner.nextLine();
            do {
                System.out.println("Enter a identify Card:");
                IDCard = scanner.nextLine();
                if (!IDCard.matches(Regex.REGEX_IDCARD_EMPLOYEE)) {
                    System.err.println("No valid, there are 9 numeric characters ");
                }
            } while (!IDCard.matches(Regex.REGEX_IDCARD_EMPLOYEE));
            do {
                System.out.println("Enter a Phone Number");
                phoneNumber = scanner.nextLine();
                if (!phoneNumber.matches(Regex.REGEX_PHONE_NUMBER)) {
                    System.err.println("No valid, phoneNumber must have 10 numbers");
                }
            } while (!phoneNumber.matches(Regex.REGEX_PHONE_NUMBER));
            System.out.println("Enter a email:");
            String email = scanner.nextLine();
            System.out.println("Enter a level (Intermediate),(College),(University),(After University) ");
            String level = scanner.nextLine();
            System.out.println("Enter a position");
            String position = scanner.nextLine();
            do {
                System.out.println("Enter a salary");
                salary = Integer.parseInt(scanner.nextLine());
                if (salary <= 0) {
                    System.err.println("Salary must bigger than 0, please enter again");
                }
            } while (salary <= 0);
            Employee employee = new Employee(id, name, date, gender, IDCard, phoneNumber, email, level, position, salary);
            repository.addEmployee(employee);
        } catch (Exception e){
            System.err.println("No valid, please enter again");
        }
    }

    @Override
    public void editEmployee() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a id");
            String id = scanner.nextLine();
            if (repository.searchIndex(id) == -1) {
                System.out.println("No search ID");
            } else {
                System.out.println("Enter a new ID");
                String idNew = scanner.nextLine();
                System.out.println("Enter a new name");
                String nameNew = scanner.nextLine();
                System.out.println("Enter a new dateOfBirth ");
                LocalDate dateOfBirthNew = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter a  gender ");
                String gender = scanner.nextLine();
                System.out.println("Enter a new IDCard ");
                String IDCardNew = scanner.nextLine();
                System.out.println("Enter a phone number ");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter a email ");
                String email = scanner.nextLine();
                System.out.println("Enter a level");
                String level = scanner.nextLine();
                System.out.println("Enter a position");
                String position = scanner.nextLine();
                System.out.println("Enter a new salary ");
                int salary = Integer.parseInt(scanner.nextLine());
                Employee employee = new Employee(idNew, nameNew, dateOfBirthNew, gender, IDCardNew, phoneNumber, email, level, position, salary);
                repository.editEmployee(repository.searchIndex(id), employee);
            }
        } catch (NumberFormatException e) {
            System.out.println("No valid, please enter again");
        }

    }

    @Override
    public void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a id to delete");
        String idDelete = scanner.nextLine();
        if (repository.searchIndex(idDelete) == -1) {
            System.out.println("No search employee");
        } else {
            repository.deleteEmployee(repository.searchIndex(idDelete));
            System.out.println("Deleted success");
        }
    }

    @Override
    public void searchByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name to search");
        String nameSearch = scanner.nextLine();
        List<Employee> employeeList = repository.searchEmployee(nameSearch);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
