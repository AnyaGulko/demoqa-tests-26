package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "375x667";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.savePageSource = false;
        Configuration.pageLoadStrategy="eager";
    }


    @Test
    void fillFormTests() throws FileNotFoundException {
        open("/automation-practice-form");

        $("#firstName").scrollTo().setValue("Vasya");

        $("#lastName").scrollTo().setValue("Vasechkin");

        $("#userEmail").scrollTo().setValue("vasya@qaquru.com");

        $(by("for", "gender-radio-1")).scrollTo().click();

        $("#userNumber").scrollTo().setValue("89999999999");

        // region calendar
        $("#dateOfBirthInput").scrollTo().click();
        $(by("value", "0")).scrollTo().click();
        $(by("value", "1998")).scrollTo().click();
        $(by("aria-label", "Choose Wednesday, January 21st, 1998")).scrollTo().click();
        // endregion

        $("#subjectsInput").scrollTo().setValue("12345");

        $(by("for", "hobbies-checkbox-2")).scrollTo().click();

        var file = new File("/Users/ingver/Тестирование/qa quru/test.txt");
        $("#uploadPicture").scrollTo().uploadFile(file);


        $("#currentAddress").scrollTo().setValue("Moscow, Lenina street, 2/1");

        $("#react-select-3-input").scrollTo().setValue("Rajasthan");
        $("#react-select-3-input").pressEnter();

        $("#react-select-4-input").scrollTo().setValue("Agra");
        $("#react-select-4-input").pressEnter();

        $("#submit").scrollTo().pressEnter();
    }

    @AfterAll
    static void afterAll() {
        closeWindow();
    }
}
