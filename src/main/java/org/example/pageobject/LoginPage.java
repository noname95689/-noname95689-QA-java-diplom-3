package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.example.model.LoginData;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends HeaderPage {

    //Заголовок c надписью "Вход".
    private SelenideElement headerLoginPage = $(byXpath("//*[contains(text(),'Вход')]"));

    //Поле ввода "Email"
    private SelenideElement inputEmailLoginPage = $(byXpath(".//input[@type='text']"));

    //Поле ввода "Пароль"
    private SelenideElement inputPasswordLoginPage = $(byXpath(".//input[@type='password']"));

    //Кнопка "Войти"
    private SelenideElement enterButtonLoginPage = $(byXpath(".//button[text()='Войти']"));

    //Кнопка "Зарегистрироваться"
    private SelenideElement registrationButtonLoginPage = $(byXpath(".//a[text()='Зарегистрироваться']"));

    //Кнопка "Восстановить пароль"
    private SelenideElement restorePasswordButton = $(byXpath(".//a[text()='Восстановить пароль']"));

    public SelenideElement getRestorePasswordButton() {
        return restorePasswordButton;
    }

    public SelenideElement getHeaderLoginPage() {
        headerLoginPage.scrollIntoView(true);
        return headerLoginPage;
    }

    public void clickOnRegistrationButton() {
        registrationButtonLoginPage.click();
    }

    public void inputLoginData() {
        LoginData loginData = LoginData.getCorrectLoginData();
        inputEmailLoginPage.sendKeys(loginData.getEmail());
        inputPasswordLoginPage.sendKeys(loginData.getPassword());
        enterButtonLoginPage.scrollIntoView(true).click();
    }
}
