package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {
    @BeforeAll
    static void setupConfig() {
        browser = System.getProperty("browser", "chrome");
        browserSize = System.getProperty("browser_size", "1920x1080");
        browserVersion = System.getProperty("browser_version", "122.0");
        baseUrl = "https://demoqa.com";
        savePageSource = false;
        pageLoadStrategy = "eager";
        webdriverLogsEnabled = true;
        String remoteUrl = System.getProperty("remote_url");
        if (remoteUrl != null) {
            String auth = System.getProperty("auth");
            remote = "https://" + auth + "@" + remoteUrl;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void disposeWindow() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
