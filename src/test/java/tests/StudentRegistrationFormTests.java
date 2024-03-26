package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class StudentRegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullSuccessfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Vasya")
                .setLastName("Vasechkin")
                .setEmail("vasya@qaquru.com")
                .setGender("Male")
                .setUserNumber("9993334455")
                .setDateBirth("29", "July", "2000")
                .setSubject("Math")
                .setHobby("Sports")
                .setFile("test.jpg")
                .setCurrentAddress("Moscow, Lenina street, 2/1")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .pressButtonSubmit();

        registrationPage.checkResult("Student Name", "Vasya Vasechkin")
                .checkResult("Student Email", "vasya@qaquru.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9993334455")
                .checkResult("Date of Birth", "29 July,2000")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "test.jpg")
                .checkResult("Address", "Moscow, Lenina street, 2/1")
                .checkResult("State and City", "Rajasthan Jaipur");

    }

    @Test
    void minimumSuccessfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Pupsen")
                .setLastName("Vupsen")
                .setGender("Male")
                .setUserNumber("9993334455")
                .pressButtonSubmit();

        registrationPage.checkResult("Student Name", "Pupsen Vupsen")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9993334455");
    }

    @Test
    void failedRegistrationTest() {
        registrationPage.openPage()
                .pressButtonSubmit();

        registrationPage.errorFirstName()
                .errorLastName()
                .errorGender()
                .errorUserNumber();
    }
}
