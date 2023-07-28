package resort_furama.model.person;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Person implements Serializable {
    private static final long serialVersionUID = 7710L;
    private String id;
    private String name;
    private LocalDate DateOfBirth;
    private String gender;
    private String identityCard;
    private String PhoneNumber;
    private String email;

    public Person() {
    }

    public Person(String id, String name, LocalDate dateOfBirth, String gender, String identityCard, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.DateOfBirth = dateOfBirth;
        this.gender = gender;
        this.identityCard = identityCard;
        this.PhoneNumber = phoneNumber;
        this.email = email;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", identityCard=" + identityCard +
                ", PhoneNumber=" + PhoneNumber +
                ", email='" + email + '\'' ;
    }
}
