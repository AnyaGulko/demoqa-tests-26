package tests;

import Steps.TextBoxSteps;
import org.junit.jupiter.api.Test;

public class TextBoxFormTests extends TestBase {
    TextBoxSteps textBoxSteps = new TextBoxSteps();

    @Test
    void fullSuccessfulTextBoxTest() {
        textBoxSteps.openPage()
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
