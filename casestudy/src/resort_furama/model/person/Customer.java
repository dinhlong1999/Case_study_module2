package resort_furama.model.person;

import java.time.LocalDate;

public class Customer extends Person {
    private String typeCustomer;
    private String address;

    public Customer(String id, String name, LocalDate dateOfBirth, String gender, String identityCard, String phoneNumber, String email, String typeCustomer, String address) {
        super(id, name, dateOfBirth, gender, identityCard, phoneNumber, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public Customer() {
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
