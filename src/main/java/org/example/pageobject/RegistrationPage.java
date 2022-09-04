package org.example.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.model.RegistrationData;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPage extends HeaderPage {

    public String urlRegistrationPage = "https://stellarburgers.nomoreparties.site/register";

    //Поля ввода "Имя" и "Фамилия"
    private ElementsCollection inputFieldsRegistration = $$(byXpath(".//input[@type='text']"));

    /*//Поле ввода "Имя"
    private SelenideElement inputNameRegistration = $(byXpath("//div[contains(@class, 'input_type_text') and contains(.//label, 'Имя')]"));

    //Поле ввода "Email"
    private SelenideElement inputEmailRegistration = $(byXpath(
            "//div[contains(@class, 'input_type_text') and contains(.//label, 'Email')]"));*/

    //Поле ввода "Пароль"
    private SelenideElement inputPasswordRegistration = $(byXpath(".//input[@type='password']"));

    //Кнопка "Зарегистрироваться"
    private SelenideElement registrationButton = $(byXpath("//*[contains(text(),'Зарегистрироваться')]"));

    String urlMainPage = "https://stellarburgers.nomoreparties.site/";

    //Сообщение об ошибке "Некорректный пароль"
    private SelenideElement passwordError = $(byXpath("//*[contains(text(),'Некорректный пароль')]"));

    //Кнопка "Войти" возле надписи "Уже зарегистрированы?"
    private SelenideElement loginButtonRegistrationPage = $(byXpath(".//a[text()='Войти']"));

    public SelenideElement getPasswordError() {
        return passwordError;
    }

    public SelenideElement getLoginButtonRegistrationPage() {
        return loginButtonRegistrationPage;
    }

    public void openRegistrationPage() {
        Selenide.open(urlRegistrationPage);
    }

    public void inputRegistrationData() {
        RegistrationData registrationData = RegistrationData.getCorrectRegistrationData();
        inputFieldsRegistration.get(0).sendKeys(registrationData.getName());
        inputFieldsRegistration.get(1).sendKeys(registrationData.getEmail());
        inputPasswordRegistration.sendKeys(registrationData.getPassword());
        registrationButton.click();
    }

    public void inputRegistrationDataShortPassword() {
        RegistrationData registrationData = RegistrationData.getShortPasswordRegistrationData();
        inputFieldsRegistration.get(0).sendKeys(registrationData.getName());
        inputFieldsRegistration.get(1).sendKeys(registrationData.getEmail());
        inputPasswordRegistration.sendKeys(registrationData.getPassword());
        registrationButton.click();
    }
}
