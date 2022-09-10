package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.model.TestEnvironment;
import org.example.pageobject.*;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest {

    MainPage mainPage = page(MainPage.class);
    HeaderPage headerPage = page(HeaderPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    LoginPage loginPage = page(LoginPage.class);
    PasswordRestorationPage passwordRestorationPage = page(PasswordRestorationPage.class);
    TestEnvironment testEnvironment = new TestEnvironment();

    @Before
    public void beforeTests() {
        //Запрашиваем браузер в котором будут проходить тесты.
        Configuration.browser = testEnvironment.getBrowser();
        //Открытие браузера в полноэкранном режиме
        Configuration.startMaximized = true;
        mainPage.openMainPage();
        TestPreparation.checkIfUserCreatedAndDelete();
        Selenide.clearBrowserLocalStorage();
        TestPreparation.sendPostRegister();
    }

    @After
    public void afterTests() {
        TestPreparation.checkIfUserCreatedAndDelete();
        Selenide.clearBrowserLocalStorage();
    }


    //Авторизация через кнопку "Войти в аккаунт" на главной странице
    @Test
    public void userCanLoginWithEnterAccountButton() {
        mainPage.getEnterProfileButton().click();
        loginPage.inputLoginData();
        mainPage.getCreateOrderButton();
        MatcherAssert.assertThat("Кнопка оформить заказ не отображается - авторизация не произошла",
                mainPage.getCreateOrderButton().isDisplayed());
    }

    //Авторизация через кнопку "Личный кабинет" в шапке
    @Test
    public void userCanLoginWithProfileButtonInHeader() {
        headerPage.clickOnProfileButton();
        loginPage.inputLoginData();
        mainPage.getCreateOrderButton();
        MatcherAssert.assertThat("Кнопка оформить заказ не отображается - авторизация не произошла",
                mainPage.getCreateOrderButton().isDisplayed());
    }

    //Авторизация через кнопку "Войти" на странице регистрации
    @Test
    public void userCanLoginWithEnterAccountButtonOnRegistrationPage() {
        headerPage.clickOnProfileButton();
        loginPage.clickOnRegistrationButton();
        registrationPage.getLoginButtonRegistrationPage().click();
        loginPage.inputLoginData();
        mainPage.getCreateOrderButton();
        MatcherAssert.assertThat("Кнопка оформить заказ не отображается - авторизация не произошла",
                mainPage.getCreateOrderButton().isDisplayed());
    }

    //Авторизация через кнопку "Войти" на странице восстановления пароля.
    @Test
    public void userCanLoginWithEnterAccountButtonOnPasswordRestorationPage() {
        headerPage.clickOnProfileButton();
        loginPage.getRestorePasswordButton().click();
        passwordRestorationPage.getLoginButtonRegistrationPage().click();
        loginPage.inputLoginData();
        mainPage.getCreateOrderButton();
        MatcherAssert.assertThat("Кнопка оформить заказ не отображается - авторизация не произошла",
                mainPage.getCreateOrderButton().isDisplayed());
    }
}
