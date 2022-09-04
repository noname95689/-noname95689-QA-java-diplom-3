package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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

    @Before
    public void beforeTests() {
        //Подключение Firefox
        //Configuration.browser = "Firefox";
        //Открытие браузера в полноэкранном режиме
        Configuration.startMaximized = true;
        //Открываем главную страницу
        mainPage.openMainPage();
        //Нажимаем на кнопку принятия cookies
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
        profilePage.getExitProfileButton().click();
        MatcherAssert.assertThat("Заголовок страницы входа не отобразился - пользователь не вышел из профиля",
                loginPage.getHeaderLoginPage().isDisplayed());
    }

}
