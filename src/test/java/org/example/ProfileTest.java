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

public class ProfileTest {

    MainPage mainPage = page(MainPage.class);
    HeaderPage headerPage = page(HeaderPage.class);
    LoginPage loginPage = page(LoginPage.class);
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
        Selenide.clearBrowserLocalStorage();
        TestPreparation.sendPostRegister();
    }

    @After
    public void afterTests() {
        TestPreparation.checkIfUserCreatedAndDelete();
        Selenide.clearBrowserLocalStorage();
    }

    //Неавторизованный пользователь переходит на страницу авторизации после клика на "Личный Кабинет"
    @Test
    public void loginPageDisplayedAfterProfileClick() {
        headerPage.clickOnProfileButton();
        MatcherAssert.assertThat("Заголовок не отобразился - переход на страницу авторизации не совершен",
                loginPage.getHeaderLoginPage().isDisplayed());
    }

    //Авторизованный пользователь переходит в профиль после клика на "Личный Кабинет"
    @Test
    public void profilePageDisplayedAfterProfileClick() {
        headerPage.clickOnProfileButton();
        loginPage.inputLoginData();
        headerPage.clickOnProfileButton();
        MatcherAssert.assertThat("Кнопка выхода не отобразилась - переход в профиль не совершен",
                profilePage.getExitProfileButton().isDisplayed());
    }
}
