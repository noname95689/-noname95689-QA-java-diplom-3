package org.example.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.model.RegistrationData;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends HeaderPage {

    public String urlRegistrationPage = "https://stellarburgers.nomoreparties.site/register";

    //Поле ввода "Имя"
    /*private SelenideElement inputNameRegistration = $(byXpath(
            "//div[contains(@class, 'input pr-6 pl-6 input_type_text input_size_default') and contains(.//label, 'Имя')]"));*/

    private SelenideElement inputNameRegistration = $(byCssSelector("fieldset.Auth_fieldset__1QzWN:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));

    //Поле ввода "Email"
    /*private SelenideElement inputEmailRegistration = $(byXpath(
            "//div[contains(@class, 'input pr-6 pl-6 input_type_text input_size_default') and contains(.//label, 'Email')]"));*/

    private SelenideElement inputEmailRegistration = $(byCssSelector("fieldset.Auth_fieldset__1QzWN:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));

    //Поле ввода "Пароль"
    private SelenideElement inputPasswordRegistration = $(byXpath(".//input[@type='password']"));

    //Кнопка "Зарегистрироваться"
    private SelenideElement registrationButton = $(byXpath("//*[contains(text(),'Зарегистрироваться')]"));

    String urlMainPage = "https://stellarburgers.nomoreparties.site/";

    //Сообщение об ошибке "Некорректный пароль"
    private SelenideElement passwordError = $(byXpath("//*[contains(text(),'Некорректный пароль')]"));

    public SelenideElement getPasswordError() {
        return passwordError;
    }

    public void openRegistrationPage() {
        Selenide.open(urlRegistrationPage);
    }

    public void inputRegistrationData() {
        RegistrationData registrationData = RegistrationData.getCorrectRegistrationData();
        inputNameRegistration.sendKeys(registrationData.getName());
        inputEmailRegistration.sendKeys(registrationData.getEmail());
        inputPasswordRegistration.sendKeys(registrationData.getPassword());
        registrationButton.click();
    }

    public void inputRegistrationDataShortPassword() {
        RegistrationData registrationData = RegistrationData.getShortPasswordRegistrationData();
        inputNameRegistration.sendKeys(registrationData.getName());
        inputEmailRegistration.sendKeys(registrationData.getEmail());
        inputPasswordRegistration.sendKeys(registrationData.getPassword());
        registrationButton.click();
    }
}
