package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.model.TestEnvironment;
import org.example.pageobject.HeaderPage;
import org.example.pageobject.LoginPage;
import org.example.pageobject.MainPage;
import org.example.pageobject.RegistrationPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest {

    MainPage mainPage = page(MainPage.class);
    HeaderPage headerPage = page(HeaderPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    LoginPage loginPage = page(LoginPage.class);
    TestEnvironment testEnvironment = new TestEnvironment();

    @Before
    public void beforeTests() {
        //Запрашиваем браузер в котором будут проходить тесты.
        Configuration.browser = testEnvironment.getBrowser();
        //Открытие браузера в полноэкранном режиме
        Configuration.startMaximized = true;
        TestPreparation.checkIfUserCreatedAndDelete();
        mainPage.openMainPage();
    }

    @After
    public void afterTests() {
        TestPreparation.checkIfUserCreatedAndDelete();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void userCanBeRegistered() {
        headerPage.clickOnProfileButton();
        loginPage.clickOnRegistrationButton();
        registrationPage.inputRegistrationData();
        MatcherAssert.assertThat("Заголовок страницы аворизации не отобразился - регистрация не произошла",
                loginPage.getHeaderLoginPage().isDisplayed());
    }

   @Test
    public void userWithShortPasswordCantBeRegistered() {
        headerPage.clickOnProfileButton();
        loginPage.clickOnRegistrationButton();
        registrationPage.inputRegistrationDataShortPassword();
        MatcherAssert.assertThat("Ошибка о недопустимом пароле не отобразилась - регистрация произошла",
                loginPage.getHeaderLoginPage().isDisplayed());
    }
}
