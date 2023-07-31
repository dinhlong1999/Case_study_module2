package resort_furama.repository.employee;

import resort_furama.model.person.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> displayAll();
    void addEmployee(Employee employee);
    void editEmployee(int id, Employee employee);
    void deleteEmployee(int id);
    List<Employee> searchEmployee(String name);
    int searchIndex(String index);
    boolean searchValueLevel(String level);
    boolean searchValuePosition(String position);
    }

