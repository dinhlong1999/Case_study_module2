package resort_furama.model.person;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee  extends Person  {

    private String level;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(String id, String name, LocalDate dateOfBirth, String gender, String identityCard, String phoneNumber, String email, String level, String position, int salary ) {
        super(id, name, dateOfBirth, gender, identityCard, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }


    public  String getInformationToCSV(){
        return this.getId()+","+this.getName()+","+this.getDateOfBirth()+","+this.getGender()+","+this.getIdentityCard()+","+this.getPhoneNumber()+","+this.getEmail()+","+this.getLevel()+","+this.getPosition()+","+this.getSalary();
    }

}
