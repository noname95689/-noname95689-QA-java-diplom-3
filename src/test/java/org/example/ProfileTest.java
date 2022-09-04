package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
        MatcherAssert.assertThat("Заголовок не отобразился - переход на страницу авторизации не совершен",
                loginPage.getHeaderLoginPage().isDisplayed());
    }
}
