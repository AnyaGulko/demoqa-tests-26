package tests;

import Steps.RegistrationSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static pages.utils.RandomUtils.*;


public class StudentRegistrationFormTests extends TestBase {
    RegistrationSteps registrationSteps = new RegistrationSteps();
    String name = getRandomFirstName();
    String lastName = getRandomLastName();
    String email = getRandomEmail();
    String gender = getGender();
    String phoneNumber = getPhoneNumber();
    Date birthday = getBirthDay();
    String day = dayOfBirthday(birthday);
    String month = monthOfBirthday(birthday);
    String year = yearOfBirthday(birthday);
    String subject1 = getSubjects();
    String subject2 = getSubjects(subject1);
    String subject3 = getSubjects(subject1, subject2);
    String hobby = getHobby();
    String state = getState();
    String city = getCity(state);
    String picture = getPicture();
    String address = getAddress();

    @Test
    @Feature("Регистрация")
    @Story("Регистрация студента")
    @Owner("Anna Gulko")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("positive")
    @DisplayName("Успешная регистрация пользователя")
    void fullSuccessfulRegistrationTest() {
        registrationSteps.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateBirth(day, month, year)
                .setSubject(subject1)
                .setSubject(subject2)
                .setSubject(subject3)
                .setHobby(hobby)
                .setFile(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .pressButtonSubmit();

        registrationSteps.checkResult("Student Name", name + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject1)
                .checkResult("Subjects", subject2)
                .checkResult("Subjects", subject3)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

    }

    @Test
    @Feature("Регистрация")
    @Story("Регистрация студента")
    @Owner("Anna Gulko")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("positive")
    @DisplayName("Успешная регистрация только с обязательными полями")
    void minimumSuccessfulRegistrationTest() {
        registrationSteps.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .pressButtonSubmit();

        registrationSteps.checkResult("Student Name", name + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    @Feature("Регистрация")
    @Story("Регистрация студента")
    @Owner("Anna Gulko")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("negative")
    @DisplayName("Обработка ошибки при регистрации с пустыми полями")
    void failedRegistrationTest() {
        registrationSteps.openPage()
                .pressButtonSubmit();

        registrationSteps.errorFirstName()
                .errorLastName()
                .errorGender()
                .errorUserNumber();
    }
}
