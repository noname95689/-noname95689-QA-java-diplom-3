package org.example.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.model.RegistrationData;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends HeaderPage {

    public String urlRegistrationPage = "https://stellarburgers.nomoreparties.site/register";

    //Поле ввода "Имя"
    private SelenideElement inputNameRegistration = $(byXpath("//*[contains(text(),'Имя')]"));

    //Поле ввода "Email"
    private SelenideElement inputEmailRegistration = $(byXpath("//*[contains(text(),'Email')]"));

    //Поле ввода "Пароль"
    private SelenideElement inputPasswordRegistration = $(byXpath("//*[contains(text(),'Пароль')]"));

    //Кнопка "Зарегистрироваться"
    private SelenideElement registrationButton = $(byXpath("//*[contains(text(),'Зарегистрироваться')]"));

    String urlMainPage = "https://stellarburgers.nomoreparties.site/";

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



}
