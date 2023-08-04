package resort_furama.service.customer;

import resort_furama.model.person.Customer;
import resort_furama.repository.customer.CustomerRepository;
import resort_furama.repository.customer.ICustomerRepository;
import resort_furama.until.Regex;
import resort_furama.until.TypeError;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private ICustomerRepository repositoryCustomer = new CustomerRepository();

    @Override
    public void displayListCustomer() {
        List<Customer> customerList = repositoryCustomer.displayListCustomer();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void addNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        String typeCustomer;
        String id;
        String name;
        LocalDate birthday;
        String identityCard;
        String phoneNumber;
        while (true) {
            try {
                do {
                    System.out.println("Please enter ID customer (TRUE: KH-XXXX), IN THERE: X(0-9)");
                    id = scanner.nextLine();
                    if (!Regex.checkIdCustomer(id)) {
                        System.err.println(TypeError.ERROR_ID_CUSTOMER);
                    }
                } while (!Regex.checkIdCustomer(id));

                do {
                    System.out.println("Please enter name customer (TRUE:The first letter of the name must be capitalized");
                    name = scanner.nextLine();
                    if (!Regex.checkName(name)) {
                        System.err.println(TypeError.ERROR_NAME);
                    }
                } while (!Regex.checkName(name));

                do {
                    System.out.println("Please enter a birthday");
                    birthday = LocalDate.parse(scanner.nextLine());
                    if (!Regex.checkBirthday(birthday)) {
                        System.err.println(TypeError.ERROR_BIRTHDAY);
                    }
                } while (!Regex.checkBirthday(birthday));

                System.out.println("Please enter gender");
                String gender = scanner.nextLine();

                do {
                    System.out.println("Enter a identify Card");
                    identityCard = scanner.nextLine();
                    if (!Regex.checkIdentity(identityCard)) {
                        System.err.println(TypeError.ERROR_IDENTITY);
                    }
                } while (!Regex.checkIdentity(identityCard));

                do {
                    System.out.println("Please enter phone number");
                    phoneNumber = scanner.nextLine();
                    if (!Regex.checkPhoneNumber(phoneNumber)) {
                        System.err.println(TypeError.ERROR_PHONE_NUMBER);
                    }
                } while (!Regex.checkPhoneNumber(phoneNumber));


                System.out.println("Enter a email");
                String email = scanner.nextLine();

                do {
                    System.out.println("Enter a type customer: Diamond, Platinum, Gold, Silver, Member ");
                    typeCustomer = scanner.nextLine();
                    if (!repositoryCustomer.searchValueTypeCustomer(typeCustomer)) {
                        System.err.println("NO VALID, TRUE: DIAMOND, PLATINUM, GOLD, SILVER, MEMBER ");
                    }
                } while (!repositoryCustomer.searchValueTypeCustomer(typeCustomer));
                System.out.println("Enter a address");
                String address = scanner.nextLine();
                Customer customer = new Customer(id, name, birthday, gender, identityCard, phoneNumber, email, typeCustomer, address);
                repositoryCustomer.addCustomer(customer);
                break;
            } catch (Exception e) {
                System.err.println("NO VALID, PLEASE ENTER AGAIN");
            }
        }

    }

    @Override
    public void editCustomer() {
        try {
            Scanner scanner = new Scanner(System.in);
            String typeCustomerNew;
            System.out.println("Enter a id to edit");
            String idEdit = scanner.nextLine();
            if (repositoryCustomer.searchIndex(idEdit) == -1) {
                System.out.println("No search id to edit");
            } else {
                String idNew;
                String nameNew;
                LocalDate birthdayNew;
                String identityNew;
                String phoneNumberNew;

                while (true) {
                    try {
                        do {
                            System.out.println("Please enter ID new customer (TRUE: KH-XXXX), IN THERE: X(0-9)");
                            idNew = scanner.nextLine();
                            if (!Regex.checkIdCustomer(idNew)) {
                                System.err.println(TypeError.ERROR_ID_CUSTOMER);
                            }
                        } while (!Regex.checkIdCustomer(idNew));

                        do {
                            System.out.println("Please enter name customer new (TRUE:The first letter of the name must be capitalized");
                            nameNew = scanner.nextLine();
                            if (!Regex.checkName(nameNew)) {
                                System.err.println(TypeError.ERROR_NAME);
                            }
                        } while (!Regex.checkName(nameNew));

                        do {
                            System.out.println("Please enter a birthday");
                            birthdayNew = LocalDate.parse(scanner.nextLine());
                            if (!Regex.checkBirthday(birthdayNew)) {
                                System.err.println(TypeError.ERROR_BIRTHDAY);
                            }
                        } while (!Regex.checkBirthday(birthdayNew));


                        System.out.println("Enter a gender new");
                        String genderNew = scanner.nextLine();


                        do {
                            System.out.println("Enter a identify Card");
                            identityNew = scanner.nextLine();
                            if (!Regex.checkIdentity(identityNew)) {
                                System.err.println(TypeError.ERROR_IDENTITY);
                            }
                        } while (!Regex.checkIdentity(identityNew));

                        do {
                            System.out.println("Please enter phone number");
                            phoneNumberNew = scanner.nextLine();
                            if (!Regex.checkPhoneNumber(phoneNumberNew)) {
                                System.err.println(TypeError.ERROR_PHONE_NUMBER);
                            }
                        } while (!Regex.checkPhoneNumber(phoneNumberNew));

                        System.out.println("Enter an email new");
                        String emailNew = scanner.nextLine();


                        do {
                            System.out.println("Enter a type customer: Diamond, Platinum, Gold, Silver, Member ");
                            typeCustomerNew = scanner.nextLine();
                            if (!repositoryCustomer.searchValueTypeCustomer(typeCustomerNew)) {
                                System.err.println("NO VALID, TRUE: DIAMOND, PLATINUM, GOLD, SILVER, MEMBER ");
                            }
                        } while (!repositoryCustomer.searchValueTypeCustomer(typeCustomerNew));

                        System.out.println("Enter a address new");
                        String address = scanner.nextLine();

                        Customer customer = new Customer(idNew, nameNew, birthdayNew, genderNew, identityNew, phoneNumberNew, emailNew, typeCustomerNew, address);
                        repositoryCustomer.editCustomer(repositoryCustomer.searchIndex(idEdit), customer);
                        break;
                    } catch (Exception e) {
                        System.out.println("NO VALID, ENTER AGAIN");
                    }

                }

            }
        } catch (Exception e) {
            System.err.println("NO VALID, PLEASE ENTER AGAIN");
        }

    }

    @Override
    public void deleteCustomer() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter id to delete");
            String id = scanner.nextLine();
            if (repositoryCustomer.searchIndex(id) == -1) {
                System.out.println("No search customer");
            } else {
                repositoryCustomer.deleteCustomer(repositoryCustomer.searchIndex(id));
            }
        } catch (NumberFormatException e) {
            System.err.println("No valid, please enter again, TRUE: (KH-XXXX) in there: (X: number 0-9)");
        }

    }

    @Override
    public void searchByNameCustomer() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name to search");
            String nameSearch = scanner.nextLine();
            List<Customer> customerList = repositoryCustomer.searchName(nameSearch);
            if (customerList.size() == 0) {
                System.out.println("No search name");
            } else {
                System.out.println("Result: ");
                for (Customer customer : customerList) {
                    System.out.println(customer);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("No valid, please enter again, TRUE:(The first letter must be capitalized)");
        }

    }
}
