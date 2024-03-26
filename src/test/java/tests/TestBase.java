package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWindow;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1200x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.savePageSource = false;
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterAll
    static void afterAll() {
        closeWindow();
    }
}
