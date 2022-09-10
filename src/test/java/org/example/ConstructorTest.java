package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.pageobject.*;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;

public class ConstructorTest {

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
        TestPreparation.checkIfUserCreatedAndDelete();
        Selenide.clearBrowserLocalStorage();
        TestPreparation.sendPostRegister();
    }

    @After
    public void afterTests() {
        TestPreparation.checkIfUserCreatedAndDelete();
        Selenide.clearBrowserLocalStorage();
    }

    //Переход в раздел конструктор из личного кабинета кликом на "Конструктор"
    @Test
    public void userCanGoToConstructorWithConstructorButton() {
        headerPage.clickOnProfileButton();
        loginPage.inputLoginData();
        headerPage.clickOnProfileButton();
        headerPage.getConstructorButton().click();
        MatcherAssert.assertThat("Кнопка оформить заказ не отображается - переход на главную страницу не произошел",
                mainPage.getCreateOrderButton().isDisplayed());
    }

    //Переход в раздел конструктор из личного кабинета кликом на логотип "Stellar Burgers"
    @Test
    public void userCanGoToConstructorWithLogoButton() {
        headerPage.clickOnProfileButton();
        loginPage.inputLoginData();
        headerPage.clickOnProfileButton();
        headerPage.getLogoButton().click();
        MatcherAssert.assertThat("Кнопка оформить заказ не отображается - переход на главную страницу не произошел",
                mainPage.getCreateOrderButton().isDisplayed());
    }

    //Переход к разделу "Булки"
    @Test
    public void userCanGoToBuns() {
        mainPage.getConstructorSauce().click();
        mainPage.getConstructorBun().click();
        MatcherAssert.assertThat("Первая булочка не видна - кнопка 'Булки' не работает", mainPage.getFirstBun().isDisplayed());

    }

    //Переход к разделу "Соусы"
    @Test
    public void userCanGoToSauces() {
        mainPage.getConstructorSauce().click();
        MatcherAssert.assertThat("Первый соус не виден - кнопка 'Соусы' не работает", mainPage.getFirstSauce().isDisplayed());
    }

    //Переход к разделу "Начинки"
    @Test
    public void userCanGoToToppings() {
        mainPage.getConstructorToppings().click();
        MatcherAssert.assertThat("Первая начинка не видна - кнопка 'Начинки' не работает", mainPage.getFirstTopping().isDisplayed());
    }

}
