package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultFormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            genderRadio1 = $(byAttribute("for", "gender-radio-1")),
            genderRadio2 = $(byAttribute("for", "gender-radio-2")),
            genderRadio3 = $(byAttribute("for", "gender-radio-3")),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            buttonSubmit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultFormComponent resultFormComponent = new ResultFormComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).scrollTo().click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setDateBirth(String day, String month, String year) {
        calendarInput.scrollTo().click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setFile(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage pressButtonSubmit() {
        buttonSubmit.pressEnter();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultFormComponent.checkFormComponent(key,value);
        return this;
    }

    public RegistrationPage errorFirstName() {
        return errorInputField(firstNameInput);
    }

    public RegistrationPage errorLastName() {
        return errorInputField(lastNameInput);
    }

    public RegistrationPage errorUserNumber() {
        return errorInputField(userNumber);
    }

    public RegistrationPage errorGender() {
        return errorRadioButton(genderRadio1)
                .errorRadioButton(genderRadio2)
                .errorRadioButton(genderRadio3);
    }

    private RegistrationPage errorInputField(SelenideElement locator) {
        $(locator)
                .shouldBe(empty)
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"))
                .shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
        return this;
    }

    private RegistrationPage errorRadioButton(SelenideElement locator) {
        $(locator).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        return this;
    }

}
