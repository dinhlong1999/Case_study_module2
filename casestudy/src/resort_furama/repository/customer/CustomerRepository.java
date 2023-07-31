package resort_furama.repository.customer;

import resort_furama.model.person.Customer;
import resort_furama.until.ReadAndWrite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private static final String FILE_PATH = "D:\\module2\\Case_study_module2\\casestudy\\src\\resort_furama\\data\\customer_csv";
    private static final String[] TYPE_CUSTOMER = {"Diamond", "Platinum", "Gold", "Silver", "Member"};

    @Override
    public List<Customer> displayListCustomer() {
        List<Customer> customers = new ArrayList<>();
        List<String> stringList = ReadAndWrite.readFile(FILE_PATH);
        String[] temp;
        Customer customer;
        for (String string: stringList ) {
            temp = string.split(",");
            customer = new Customer(temp[0],temp[1],LocalDate.parse(temp[2]),temp[3],temp[4],temp[5],temp[6],temp[7],temp[8]);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        List<String> stringList = new ArrayList<>();
        stringList.add(customer.customerGetInformationToCSV());
        ReadAndWrite.writeFile(FILE_PATH, stringList, true);
    }

    @Override
    public void editCustomer(int id, Customer customer) {
        List<String> listEdit = new ArrayList<>();
        List<Customer> customers = displayListCustomer();
        customers.set(id, customer);
        for (Customer customer1 : customers) {
            listEdit.add(customer1.customerGetInformationToCSV());
        }
        ReadAndWrite.writeFile(FILE_PATH, listEdit, false);
    }

    @Override
    public void deleteCustomer(int id) {
        List<String> list = new ArrayList<>();
        List<Customer> customerList = displayListCustomer();
        customerList.remove(id);
        for (Customer customer : customerList) {
            list.add(customer.customerGetInformationToCSV());
        }
        ReadAndWrite.writeFile(FILE_PATH, list, false);
    }

    @Override
    public List<Customer> searchName(String name) {
        List<Customer> customerSearch = new ArrayList<>();
        List<Customer> customerList = displayListCustomer();
        for (Customer customer : customerList) {
            if (customer.getName().contains(name)) {
                customerSearch.add(customer);
                break;
            }
        }
        return customerSearch;
    }

    @Override
    public int searchIndex(String index) {
        List<Customer> customerList = displayListCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(index)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public boolean searchValueTypeCustomer(String typeCustomer) {
        boolean searchTypeCustomer = false;
        for (int i = 0; i < TYPE_CUSTOMER.length; i++) {
            if (TYPE_CUSTOMER[i].equals(typeCustomer)) {
                searchTypeCustomer = true;
                break;
            }
        }
        return searchTypeCustomer;
    }

}
