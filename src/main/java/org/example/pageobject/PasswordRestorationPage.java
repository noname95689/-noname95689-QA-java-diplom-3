package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PasswordRestorationPage {

    //Кнопка "Войти" возле надписи "Вспомнили пароль?"
    private SelenideElement loginButtonRegistrationPage = $(byCssSelector(".Auth_link__1fOlj"));

    public SelenideElement getLoginButtonRegistrationPage() {
        return loginButtonRegistrationPage;
    }
}
