package resort_furama.repository.customer;

import resort_furama.model.person.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> displayListCustomer();
    void addCustomer(Customer customer);
    void editCustomer(int id, Customer customer);
    void deleteCustomer(int id);
    List<Customer> searchName(String name);
    int searchIndex(String index);
    boolean searchValueTypeCustomer(String typeCustomer);


}
