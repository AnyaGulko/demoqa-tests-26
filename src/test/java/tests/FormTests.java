package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "430x932";
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

        $("#userNumber").scrollTo().setValue("9993334455");

        // region calendar
        $("#dateOfBirthInput").scrollTo().click();
        $(by("value", "0")).scrollTo().click();
        $(by("value", "1998")).scrollTo().click();
        $(by("aria-label", "Choose Wednesday, January 21st, 1998")).scrollTo().click();
        // endregion

        $("#subjectsInput").scrollTo().setValue("Maths").pressEnter();

        $(by("for", "hobbies-checkbox-2")).scrollTo().click();

        var file = new File("/Users/ingver/Desktop/test.jpg");
        $("#uploadPicture").scrollTo().uploadFile(file);
        
        $("#currentAddress").scrollTo().setValue("Moscow, Lenina street, 2/1");

        $("#state").click();
        $(byText("Rajasthan")).click();

        $("#city").click();
        $(byText("Jaipur")).click();

        $("#submit").scrollTo().pressEnter();


        $$("tr").get(1).shouldHave(text("Vasya Vasechkin"));
        $$("tr").get(2).shouldHave(text("vasya@qaquru.com"));
        $$("tr").get(3).shouldHave(text("Male"));
        $$("tr").get(4).shouldHave(text("9993334455"));
        $$("tr").get(5).shouldHave(text("21 January,1998"));
        $$("tr").get(6).shouldHave(text("Maths"));
        $$("tr").get(7).shouldHave(text("Reading"));
        $$("tr").get(8).shouldHave(text("test.jpg"));
        $$("tr").get(9).shouldHave(text("Moscow, Lenina street, 2/1"));
        $$("tr").get(10).shouldHave(text("Rajasthan Jaipur"));
    }

    @AfterAll
    static void afterAll() {
        closeWindow();
    }
}
