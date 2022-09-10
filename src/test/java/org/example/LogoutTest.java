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

public class LogoutTest {

    MainPage mainPage = page(MainPage.class);
    HeaderPage headerPage = page(HeaderPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    LoginPage loginPage = page(LoginPage.class);
    PasswordRestorationPage passwordRestorationPage = page(PasswordRestorationPage.class);
    ProfilePage profilePage = page(ProfilePage.class);
    TestEnvironment testEnvironment = new TestEnvironment();

    @Before
    public void beforeTests() {
        //Запрашиваем браузер в котором будут проходить тесты.
        Configuration.browser = testEnvironment.getBrowser();
        //Открытие браузера в полноэкранном режиме
        Configuration.startMaximized = true;
        mainPage.openMainPage();
        TestPreparation.checkIfUserCreatedAndDelete();
        TestPreparation.sendPostRegister();
    }

    @After
    public void afterTests() {
        TestPreparation.checkIfUserCreatedAndDelete();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void userCanLogout() {
        mainPage.getEnterProfileButton().click();
        loginPage.inputLoginData();
        headerPage.clickOnProfileButton();
        profilePage.getExitProfileButton().scrollIntoView(true).click();
        MatcherAssert.assertThat("Заголовок страницы входа не отобразился - пользователь не вышел из профиля",
                loginPage.getHeaderLoginPage().isDisplayed());
    }
}
