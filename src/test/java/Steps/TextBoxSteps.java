package Steps;

import io.qameta.allure.Step;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxSteps {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Step("Открыть страницу с формой text box")
    public TextBoxSteps openPage() {
        open("/text-box");
        return this;
    }

    @Step("Ввести имя {value}")
    public TextBoxSteps setUserName(String value) {
        textBoxPage.getUserName().setValue(value);
        return this;
    }

    @Step("Ввести Email {value}")
    public TextBoxSteps setEmail(String value) {
        textBoxPage.getUserEmail().setValue(value);
        return this;
    }

    @Step("Ввести текущий адрес {value}")
    public TextBoxSteps setCurrentAddress(String value) {
        textBoxPage.getCurrentAddress().setValue(value);
        return this;
    }

    @Step("Ввести фактический адрес {value}")
    public TextBoxSteps setPermanentAddress(String value) {
        textBoxPage.getPermanentAddress().setValue(value);
        return this;
    }

    @Step("Нажать на кнопку 'Submit'")
    public TextBoxSteps pressSubmit() {
        textBoxPage.getSubmit().scrollTo().click();
        return this;
    }

    @Step("Проверить что введенное значение {value} отображается в поле {key}")
    public TextBoxSteps checkResult(String key, String value) {
        textBoxPage.getOutputForm().should(visible);
        textBoxPage.getOutputForm().$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public TextBoxSteps removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
}
