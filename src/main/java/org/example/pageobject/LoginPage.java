package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.example.model.LoginData;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends HeaderPage {

    private String urlLoginPage = "https://stellarburgers.nomoreparties.site/login";

    //Заголовок страницы входа в приложение.

    //Поле ввода "Email"
    private SelenideElement inputEmailLoginPage = $(byCssSelector(".input_type_text > input:nth-child(2)"));

    //Поле ввода "Пароль"
    private SelenideElement inputPasswordLoginPage = $(byXpath(".//input[@type='password']"));

    //Кнопка "Войти"
    private SelenideElement enterButtonLoginPage = $(byXpath(".//button[text()='Войти']"));

    //Кнопка "Зарегистрироваться"
    private SelenideElement registrationButtonLoginPage = $(byXpath(".//a[text()='Зарегистрироваться']"));

    //Кнопка "Восстановить пароль"

    public void clickOnRegistrationButton() {
        registrationButtonLoginPage.click();
    }

    public void inputLoginData() {
        LoginData loginData = LoginData.getCorrectLoginData();
        inputEmailLoginPage.sendKeys(loginData.getEmail());
        inputPasswordLoginPage.sendKeys(loginData.getPassword());
        enterButtonLoginPage.click();
    }
}
