package resort_furama.until;

import java.time.LocalDate;
import java.util.Scanner;

public class Regex {
    public static final String REGEX_ID_EMPLOYEE = "^[NV]{2}\\-[0-9]{4}$";
    public static final String REGEX_NAME = "^[A-Z][a-z|A-Z| ]*$";
    public static final String REGEX_IDCARD = "^[0-9]{9,12}$";
    public static final String REGEX_PHONE_NUMBER = "^[0|84][0-9]{9}$";
    public static final String REGEX_ID_CUSTOMER = "^[KH]{2}\\-[0-9]{4}$";
    static Scanner scanner = new Scanner(System.in);

    public static boolean checkIdEmployee(String id) {
        return id.matches(REGEX_ID_EMPLOYEE);
    }

    public static boolean checkName(String name) {
        return name.matches(REGEX_NAME);
    }

    public static boolean checkIdCustomer(String id) {
        return id.matches(REGEX_ID_CUSTOMER);
    }

    public static boolean checkBirthday(LocalDate birthday) {
        if (LocalDate.now().compareTo(birthday) > 18) {
            return true;
        }
        return false;
    }


    public static boolean checkIdentity(String identity) {
        return identity.matches(REGEX_IDCARD);
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(REGEX_PHONE_NUMBER);
    }


}