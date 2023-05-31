package utility;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import java.util.Locale;

public class GenerateRandomData {

    static Faker usFaker = new Faker(new Locale("en-US"));

    public static String firstName() {
        return usFaker.name().firstName()+"abc";
    }
    public static String lastName() {
        return usFaker.name().lastName();
    }
    public static String jobTitle() { return  usFaker.job().title();}
    public static String password() {return usFaker.internet().password()+"A"+"!"+"1";}
    public static int day() {return usFaker.number().numberBetween(1,28);}
    public static int month1to12() {return usFaker.number().numberBetween(1,12);}
    public static int year() {return usFaker.number().numberBetween(1960,2000);}
    public static String city() {return usFaker.address().city();}
    public static String state() {return usFaker.address().state();}
    public static String address() {return usFaker.address().secondaryAddress();}
    public static String zipcode() {return usFaker.address().zipCode();}
    public static long phone() {return usFaker.number().numberBetween(0000000, 9999999);}

    public static int idNumber() {
        return usFaker.number().numberBetween(1,9999);
    }


    public static void main(String[] args) {
        System.out.println(phone());
    }

}
