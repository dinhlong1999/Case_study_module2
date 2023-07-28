package resort_furama.repository.employee;

import resort_furama.model.person.Employee;
import resort_furama.until.ReadAndWrite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private List<Employee> employees = switchFromCsvToEmployee();
    private static final String FILE_PATH = "D:\\module2\\casestudy\\src\\resort_furama\\data\\resort_csv";


    public List<Employee> switchFromCsvToEmployee() {
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
    public List<Employee> displayAll() {
        return employees;
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
        employees.set(id,employee);
        stringList.add(employee.getInformationToCSV());
        ReadAndWrite.writeFile(FILE_PATH,stringList,false);
    }




    @Override
    public void deleteEmployee(int id) {
    List<String> list = new ArrayList<>();
    employees.remove(id);
        for (Employee employee:employees) {
            list.add(employee.getInformationToCSV());
        }
       ReadAndWrite.writeFile(FILE_PATH,list,false);
    }

    @Override
    public List<Employee> searchEmployee(String name) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().contains(name)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    public int searchIndex(String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
