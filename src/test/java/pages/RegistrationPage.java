package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

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




//getters
    public SelenideElement getFirstNameInput() {
        return firstNameInput;
    }

    public SelenideElement getLastNameInput() {
        return lastNameInput;
    }

    public SelenideElement getUserEmailInput() {
        return userEmailInput;
    }

    public SelenideElement getGenderWrapper() {
        return genderWrapper;
    }

    public SelenideElement getGenderRadio1() {
        return genderRadio1;
    }

    public SelenideElement getGenderRadio2() {
        return genderRadio2;
    }

    public SelenideElement getGenderRadio3() {
        return genderRadio3;
    }

    public SelenideElement getUserNumber() {
        return userNumber;
    }

    public SelenideElement getCalendarInput() {
        return calendarInput;
    }

    public SelenideElement getSubjectsInput() {
        return subjectsInput;
    }

    public SelenideElement getHobbiesCheckbox() {
        return hobbiesCheckbox;
    }

    public SelenideElement getUploadPicture() {
        return uploadPicture;
    }

    public SelenideElement getCurrentAddress() {
        return currentAddress;
    }

    public SelenideElement getState() {
        return state;
    }

    public SelenideElement getCity() {
        return city;
    }

    public SelenideElement getButtonSubmit() {
        return buttonSubmit;
    }
}
