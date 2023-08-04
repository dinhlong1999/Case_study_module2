package resort_furama.service.employee;

import resort_furama.model.person.Employee;
import resort_furama.repository.employee.EmployeeRepository;
import resort_furama.repository.employee.IEmployeeRepository;
import resort_furama.until.Regex;
import resort_furama.until.TypeError;

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
        String idCard;
        String phoneNumber;
        LocalDate date;
        int salary;
        String level;
        String position;
        while (true) {
            try {
                do {
                    System.out.println("Enter a id, format (NV-XXXX)");
                    id = scanner.nextLine();
                    if (!Regex.checkIdEmployee(id)) {
                        System.err.println(TypeError.ERROR_ID_EMPLOYEE);
                    }
                } while (!Regex.checkIdEmployee(id));


                do {
                    System.out.println("Enter a name:");
                    name = scanner.nextLine();
                    if (!Regex.checkName(name)) {
                        System.err.println(TypeError.ERROR_NAME);
                    }
                } while (!Regex.checkName(name));


                do {
                    System.out.println("Enter a date of birth(Year-Month-Day)");
                    date = LocalDate.parse(scanner.nextLine());
                    if (!Regex.checkBirthday(date)) {
                        System.err.println(TypeError.ERROR_BIRTHDAY);
                    }
                } while (!Regex.checkBirthday(date));


                System.out.println("Enter a gender");
                String gender = scanner.nextLine();


                do {
                    System.out.println("Enter a identify Card:");
                    idCard = scanner.nextLine();
                    if (!Regex.checkIdentity(idCard)) {
                        System.err.println(TypeError.ERROR_IDENTITY);
                    }
                } while (!Regex.checkIdentity(idCard));


                do {
                    System.out.println("Enter a Phone Number");
                    phoneNumber = scanner.nextLine();
                    if (!Regex.checkPhoneNumber(phoneNumber)) {
                        System.err.println(TypeError.ERROR_PHONE_NUMBER);
                    }
                } while (!Regex.checkPhoneNumber(phoneNumber));


                System.out.println("Enter a email:");
                String email = scanner.nextLine();
                do {
                    System.out.println("Enter a level (Intermediate),(College),(University),(After University) ");
                    level = scanner.nextLine();
                    if (!repository.searchValueLevel(level)) {
                        System.err.println("No valid,level must: (Intermediate),(College),(University),(After University) ");
                    }
                } while (!repository.searchValueLevel(level));
                do {
                    System.out.println("Enter a position");
                    position = scanner.nextLine();
                    if (!repository.searchValuePosition(position)) {
                        System.err.println("No valid, position must: Receptionist,Serve profession, Expert, Supervisor, Manage, Manager ");
                    }
                } while (!repository.searchValuePosition(position));
                do {
                    System.out.println("Enter a salary");
                    salary = Integer.parseInt(scanner.nextLine());
                    if (salary <= 0) {
                        System.err.println("Salary must bigger than 0, please enter again");
                    }
                } while (salary <= 0);
                Employee employee = new Employee(id, name, date, gender, idCard, phoneNumber, email, level, position, salary);
                repository.addEmployee(employee);
                break;
            } catch (Exception e) {
                System.err.println("No valid, please enter again");
            }
        }

    }

    @Override
    public void editEmployee() {
        String idNew;
        String nameNew;
        String idCardNew;
        String phoneNumber;
        LocalDate dateOfBirthNew;
        String level;
        int salary;
        String position;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a id");
            String id = scanner.nextLine();
            if (repository.searchIndex(id) == -1) {
                System.out.println("No search ID");
            } else {
                while (true) {
                    try {
                        do {
                            System.out.println("Enter a new ID");
                            idNew = scanner.nextLine();
                            if (!Regex.checkIdEmployee(idNew)) {
                                System.err.println(TypeError.ERROR_ID_EMPLOYEE);
                            }
                        } while (!Regex.checkIdEmployee(idNew));

                        do {
                            System.out.println("Enter a new name");
                            nameNew = scanner.nextLine();
                            if (!Regex.checkName(nameNew)) {
                                System.err.println(TypeError.ERROR_NAME);
                            }
                        } while (!Regex.checkName(nameNew));

                        do {
                            System.out.println("Enter a new dateOfBirth ");
                            dateOfBirthNew = LocalDate.parse(scanner.nextLine());
                            if (!Regex.checkBirthday(dateOfBirthNew)) {
                                System.err.println(TypeError.ERROR_BIRTHDAY);
                            }
                        } while (!Regex.checkBirthday(dateOfBirthNew));

                        System.out.println("Enter a  gender ");
                        String gender = scanner.nextLine();

                        do {
                            System.out.println("Enter a new IDCard ");
                            idCardNew = scanner.nextLine();
                            if (!Regex.checkIdentity(idCardNew)) {
                                System.err.println(TypeError.ERROR_IDENTITY);
                            }
                        } while (!Regex.checkIdentity(idCardNew));

                        do {
                            System.out.println("Enter a phone number ");
                            phoneNumber = scanner.nextLine();
                            if (!Regex.checkPhoneNumber(phoneNumber)) {
                                System.err.println(TypeError.ERROR_PHONE_NUMBER);
                            }
                        } while (!Regex.checkPhoneNumber(phoneNumber));

                        System.out.println("Enter a email ");
                        String email = scanner.nextLine();

                        do {
                            System.out.println("Enter a level");
                            level = scanner.nextLine();
                            if (!repository.searchValueLevel(level)) {
                                System.err.println("No valid, level must: (Intermediate),(College),(University),(After University) ");
                            }
                        } while (!repository.searchValueLevel(level));

                        do {
                            System.out.println("Enter a position");
                            position = scanner.nextLine();
                            if (!repository.searchValuePosition(position)) {
                                System.err.println("No valid, position must: Receptionist,Serve profession, Expert, Supervisor, Manage, Manager");
                            }
                        } while (!repository.searchValuePosition(position));

                        do {
                            System.out.println("Enter a new salary ");
                            salary = Integer.parseInt(scanner.nextLine());
                            if (salary <= 0) {
                                System.err.println("No valid, salary must bigger than 0");
                            }
                        } while (salary <= 0);

                        Employee employee = new Employee(idNew, nameNew, dateOfBirthNew, gender, idCardNew, phoneNumber, email, level, position, salary);
                        repository.editEmployee(repository.searchIndex(id), employee);
                        break;
                    } catch (Exception e) {
                        System.err.println("No valid, please enter again");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No valid, please enter again");
        }

    }


    @Override
    public void deleteEmployee() {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a id to delete");
                String idDelete = scanner.nextLine();
                if (repository.searchIndex(idDelete) == -1) {
                    System.out.println("No search employee");
                } else {
                    repository.deleteEmployee(repository.searchIndex(idDelete));
                    System.out.println("Deleted success");

                }
            }catch (NumberFormatException e){
                System.err.println("FORMAT NO VALID, PLEASE ENTER AGAIN");
            }
        }



    @Override
    public void searchByName() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name to search");
            String nameSearch = scanner.nextLine();
            List<Employee> employeeList = repository.searchEmployee(nameSearch);
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }catch (NumberFormatException e){
            System.err.println("FORMAT NO VALID, PLEASE ENTER AGAIN");
        }

    }
}
