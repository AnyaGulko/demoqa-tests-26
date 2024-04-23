package Steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.RegistrationPage;
import pages.components.CalendarComponent;
import pages.components.ResultFormComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationSteps {
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultFormComponent resultFormComponent = new ResultFormComponent();
    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Открыть страницу с формой регистрации")
    public RegistrationSteps openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Ввести имя {value}")
    public RegistrationSteps setFirstName(String value) {
        registrationPage.getFirstNameInput().setValue(value);
        return this;
    }

    @Step("Ввести фамилию {value}")
    public RegistrationSteps setLastName(String value) {
        registrationPage.getLastNameInput().setValue(value);
        return this;
    }

    @Step("Ввести email {value}")
    public RegistrationSteps setEmail(String value) {
        registrationPage.getUserEmailInput().setValue(value);
        return this;
    }

    @Step("Выбрать гендер {value}")
    public RegistrationSteps setGender(String value) {
        registrationPage.getGenderWrapper().$(byText(value)).scrollTo().click();
        return this;
    }

    @Step("Ввести номер телефона {value}")
    public RegistrationSteps setUserNumber(String value) {
        registrationPage.getUserNumber().setValue(value);
        return this;
    }

    @Step("Выбрать дату рождения через датапикер {value}")
    public RegistrationSteps setDateBirth(String day, String month, String year) {
        registrationPage.getCalendarInput().scrollTo().click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбрать предмет {value}")
    public RegistrationSteps setSubject(String value) {
        registrationPage.getSubjectsInput().setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать хобби {value}")
    public RegistrationSteps setHobby(String value) {
        registrationPage.getHobbiesCheckbox().$(byText(value)).click();
        return this;
    }

    @Step("Загрузить файл {value}")
    public RegistrationSteps setFile(String value) {
        registrationPage.getUploadPicture().uploadFromClasspath(value);
        return this;
    }

    @Step("Ввести адрес {value}")
    public RegistrationSteps setCurrentAddress(String value) {
        registrationPage.getCurrentAddress().setValue(value);
        return this;
    }

    @Step("Выбрать штат {value}")
    public RegistrationSteps setState(String value) {
        registrationPage.getState().click();
        $(byText(value)).click();
        return this;
    }

    @Step("Выбрать город {value}")
    public RegistrationSteps setCity(String value) {
        registrationPage.getCity().click();
        $(byText(value)).click();
        return this;
    }

    @Step("Нажать кнопку submit")
    public RegistrationSteps pressButtonSubmit() {
        registrationPage.getButtonSubmit().pressEnter();
        return this;
    }

    @Step("Проверка соответствия введенных значений в карточке")
    public RegistrationSteps checkResult(String key, String value) {
        resultFormComponent.checkFormComponent(key, value);
        return this;
    }

    @Step("Обработка ошибки в поле 'Имя'")
    public RegistrationSteps errorFirstName() {
        return errorInputField(registrationPage.getFirstNameInput());
    }

    @Step("Обработка ошибки в поле 'Фамилия'")
    public RegistrationSteps errorLastName() {
        return errorInputField(registrationPage.getLastNameInput());
    }

    @Step("Обработка ошибки в поле 'Номер телефона'")
    public RegistrationSteps errorUserNumber() {
        return errorInputField(registrationPage.getUserNumber());
    }

    @Step("Обработка ошибки в радио кнопке 'Гендер'")
    public RegistrationSteps errorGender() {
        return errorRadioButton(registrationPage.getGenderRadio1())
                .errorRadioButton(registrationPage.getGenderRadio2())
                .errorRadioButton(registrationPage.getGenderRadio3());
    }

    private RegistrationSteps errorInputField(SelenideElement locator) {
        $(locator)
                .shouldBe(empty)
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"))
                .shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
        return this;
    }

    private RegistrationSteps errorRadioButton(SelenideElement locator) {
        $(locator).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        return this;
    }

    public RegistrationSteps removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
}
