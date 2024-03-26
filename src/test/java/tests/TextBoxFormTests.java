package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxFormTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fullSuccessfulTextBoxTest() {
        textBoxPage.openPage()
                .setUserName("Pupsen Vupsen")
                .setEmail("gusenitsa@gmail.com")
                .setCurrentAddress("Moscow, Lenina street, 2/1")
                .setPermanentAddress("Moscow, Gagarina street, 6")
                .pressSubmit();

        textBoxPage.checkResult("Name:", "Pupsen Vupsen")
                .checkResult("Email:", "gusenitsa@gmail.com")
                .checkResult("Current Address :", "Moscow, Lenina street, 2/1")
                .checkResult("Permananet Address :", "Moscow, Gagarina street, 6");
    }
}
