package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.example.model.LoginData;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends HeaderPage {

    private String urlLoginPage = "https://stellarburgers.nomoreparties.site/login";

    //Надпись "Вход"
    public SelenideElement loginPageHeader = $(byCssSelector(".Auth_login__3hAey"));

    public SelenideElement getLoginPageHeader() {
        return loginPageHeader;
    }

    //Поле ввода "Email"
    private SelenideElement inputEmailLoginPage = $(byXpath(".//input[@type='text']"));

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

    public SelenideElement getEnterButtonLoginPage() {
        return enterButtonLoginPage;
    }

    public void inputLoginData() {
        LoginData loginData = LoginData.getCorrectLoginData();
        inputEmailLoginPage.click();
        inputEmailLoginPage.sendKeys(loginData.getEmail());
        inputPasswordLoginPage.sendKeys(loginData.getPassword());
        enterButtonLoginPage.click();
    }
}
