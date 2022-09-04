package org.example.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends HeaderPage {

    String urlMainPage = "https://stellarburgers.nomoreparties.site/";

    public void openMainPage() {
        open(urlMainPage);
    }

    //Кнопка "Войти в аккаунт" - отображается для неавторизованного пользователя.
    private SelenideElement enterProfileButton = $(byXpath(".//button[text()='Войти в аккаунт']"));

    //Кнопка "Оформить заказ" - отображается для авторизованного пользователя.
    private SelenideElement createOrderButton = $(byXpath(".//button[text()='Оформить заказ']"));

    //Кнопка раздела "Булки" в конструкторе
    private SelenideElement constructorBun = $(byXpath(".//span[text()='Булки']"));

    //Кнопка раздела "Соусы" в конструкторе
    private SelenideElement constructorSauce = $(byXpath(".//span[text()='Соусы']"));

    //Кнопка раздела "Начинки" в конструкторе
    private SelenideElement constructorToppings = $(byXpath(".//span[text()='Начинки']"));

    //Первый товар в списке булок - "Флюоресцентная булка R2-D3" ".//img[@alt='Флюоресцентная булка R2-D3']"
    private SelenideElement firstBun = $(byXpath(".//img[@alt='Флюоресцентная булка R2-D3']"));

    //Первый товар в списке соусов - "Соус Spicy-X"
    private SelenideElement firstSauce = $(byXpath(".//img[@alt='Соус Spicy-X']"));

    //Первый товар в списке начинок - "Мясо бессмертных моллюсков Protostomia"
    private SelenideElement firstTopping = $(byXpath(".//img[@alt='Мясо бессмертных моллюсков Protostomia']"));

    public SelenideElement getCreateOrderButton() {
        createOrderButton.scrollIntoView(true);
        return createOrderButton;
    }

    public SelenideElement getEnterProfileButton() {
        enterProfileButton.scrollIntoView(true);
        return enterProfileButton;
    }

    public SelenideElement getConstructorBun() {
        return constructorBun;
    }

    public SelenideElement getConstructorSauce() {
        return constructorSauce;
    }

    public SelenideElement getConstructorToppings() {
        return constructorToppings;
    }

    public SelenideElement getFirstBun() {
        return firstBun;
    }

    public SelenideElement getFirstSauce() {
        return firstSauce;
    }

    public SelenideElement getFirstTopping() {
        return firstTopping;
    }
}
