package tests;

import Steps.TextBoxSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TextBoxFormTests extends TestBase {
    TextBoxSteps textBoxSteps = new TextBoxSteps();

    @Test
    @Feature("Заполнение формы TextBox")
    @Story("Заполнение формы TextBox")
    @Owner("Anna Gulko")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("positive")
    @DisplayName("Успешное заполнение формы TextBox")
    void fullSuccessfulTextBoxTest() {
        textBoxSteps.openPage()
                .removeBanner()
                .setUserName("Pupsen Vupsen")
                .setEmail("gusenitsa@gmail.com")
                .setCurrentAddress("Moscow, Lenina street, 2/1")
                .setPermanentAddress("Moscow, Gagarina street, 6")
                .pressSubmit();

        textBoxSteps.checkResult("Name:", "Pupsen Vupsen")
                .checkResult("Email:", "gusenitsa@gmail.com")
                .checkResult("Current Address :", "Moscow, Lenina street, 2/1")
                .checkResult("Permananet Address :", "Moscow, Gagarina street, 6");
    }
}
