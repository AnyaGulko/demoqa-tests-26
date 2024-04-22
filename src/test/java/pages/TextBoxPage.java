package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage {
    private final SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit"),
            outputForm = $("#output");

    public SelenideElement getOutputForm() {
        return outputForm;
    }

    public SelenideElement getSubmit() {
        return submit;
    }

    public SelenideElement getPermanentAddress() {
        return permanentAddress;
    }

    public SelenideElement getCurrentAddress() {
        return currentAddress;
    }

    public SelenideElement getUserEmail() {
        return userEmail;
    }

    public SelenideElement getUserName() {
        return userName;
    }
}
