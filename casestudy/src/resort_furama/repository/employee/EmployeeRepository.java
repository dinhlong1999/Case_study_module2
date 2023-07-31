package resort_furama.repository.employee;

import resort_furama.model.person.Employee;
import resort_furama.until.ReadAndWrite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private static final String FILE_PATH = "D:\\module2\\Case_study_module2\\casestudy\\src\\resort_furama\\data\\employee_csv";
    private static final String[] LEVEL = {"Intermediate", "College", "University", "After University"};
    private static final String[] POSITION = {"Receptionist","Serve profession","Expert","Supervisor","Manage","Manager"};


    @Override
    public List<Employee> displayAll() {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = ReadAndWrite.readFile(FILE_PATH);
        String[] temp;
        Employee employee;
        for (String s : stringList) {
            temp = s.split(",");
            employee = new Employee(temp[0], temp[1], LocalDate.parse(temp[2]), temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], Integer.parseInt(temp[9]));
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        List<String> employeeList = new ArrayList<>();
        employeeList.add(employee.getInformationToCSV());
        ReadAndWrite.writeFile(FILE_PATH, employeeList, true);
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        List<String> stringList = new ArrayList<>();
        List<Employee> employees = displayAll();
        employees.set(id, employee);
        for (Employee employee1:employees) {
            stringList.add(employee1.getInformationToCSV());
        }
        ReadAndWrite.writeFile(FILE_PATH, stringList, false);
    }


    @Override
    public void deleteEmployee(int id) {
        List<String> list = new ArrayList<>();
        List<Employee> employees = displayAll();
        employees.remove(id);
        for (Employee employee : employees) {
            list.add(employee.getInformationToCSV());
        }
        ReadAndWrite.writeFile(FILE_PATH, list, false);
    }

    @Override
    public List<Employee> searchEmployee(String name) {
        List<Employee> employeeList = new ArrayList<>();
        List<Employee> employees = displayAll();
        for (Employee employee : employees) {
            if (employee.getName().contains(name)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    public int searchIndex(String id) {
        List<Employee> employees = displayAll();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean searchValueLevel(String level) {
        boolean searchValueLevel = false;
        for (int i = 0; i < LEVEL.length; i++) {
            if (LEVEL[i].equals(level)) {
                searchValueLevel = true;
                break;
            }
        }
        return searchValueLevel;
    }

    @Override
    public boolean searchValuePosition(String position) {
        boolean searchValuePosition = false;
        for (String s: POSITION) {
            if (s.equals(position)){
                searchValuePosition = true;
                break;
            }
        }
        return searchValuePosition;
    }
}


