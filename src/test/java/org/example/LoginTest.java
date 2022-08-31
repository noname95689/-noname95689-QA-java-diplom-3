package org.example;

import org.example.pageobject.*;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;

public class LoginTest {

    MainPage mainPage = page(MainPage.class);
    HeaderPage headerPage = page(HeaderPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    LoginPage loginPage = page(LoginPage.class);
    ProfilePage profilePage = page(ProfilePage.class);

    @Test
    public void userCanLogin() {
        headerPage.clickOnProfileButton();


    }


}
