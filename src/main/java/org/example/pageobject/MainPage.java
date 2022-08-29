package org.example.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends HeaderPage {

    //Кнопка "Войти в аккаунт" - отображается для неавторизованного пользователя.
    private SelenideElement enterProfileButton = $(byXpath(".//button[text()='Войти в аккаунт']"));

    //Кнопка "Оформить заказ" - отображается для авторизованного пользователя.
    private SelenideElement createOrderButton = $(byXpath(".//button[text()='Оформить заказ']"));

    String urlMainPage = "https://stellarburgers.nomoreparties.site/";

    public void openMainPage() {
        open(urlMainPage);
    }

    public SelenideElement getCreateOrderButton() {
        return createOrderButton;
    }

}
