package org.example;

import com.codeborne.selenide.Configuration;
import org.example.model.RegistrationData;
import org.example.pageobject.HeaderPage;
import org.example.pageobject.LoginPage;
import org.example.pageobject.MainPage;
import org.example.pageobject.RegistrationPage;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest {

    MainPage mainPage = page(MainPage.class);
    HeaderPage headerPage = page(HeaderPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
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
    }

    @Test
    public void userCanBeRegistered() {
        headerPage.clickOnProfileButton();
        loginPage.clickOnRegistrationButton();
        registrationPage.inputRegistrationData();
        loginPage.inputLoginData();
        MatcherAssert.assertThat("Кнопка 'Оформить заказ' не отобразилась - авторизация не произошла",
                mainPage.getCreateOrderButton().isDisplayed());
    }

    @Test
    public void userWithShortPasswordCantBeRegistered() {

    }
}
