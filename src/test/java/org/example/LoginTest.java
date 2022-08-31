package org.example;
import com.codeborne.selenide.Configuration;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.example.pageobject.*;


import static com.codeborne.selenide.Selenide.page;

public class LoginTest {

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


    //Авторизация через кнопку "Войти в аккаунт" на главной странице
    @Test
    public void userCanLoginWithEnterAccountButton() {

    }

    //Авторизация через кнопку "Личный кабинет" в шапке
    @Test
    public void userCanLoginWithProfileButtonMainPage() {
        headerPage.clickOnProfileButton();
        loginPage.inputLoginData();
        mainPage.getCreateOrderButton().scrollIntoView(true);
        MatcherAssert.assertThat("Кнопка оформить заказ не отображается - авторизация не произошла",
                mainPage.getCreateOrderButton().isDisplayed());
    }

    //Авторизация через кнопку "Войти" на странице регистрации
    @Test
    public void userCanLoginWithEnterAccountButtonRegistrationPage() {

    }

    //Авторизация через кнопку "Войти" на странице восстановления пароля.
    @Test
    public void userCanLoginWithEnterAccountButtonPasswordRestorationPage() {

    }


}
