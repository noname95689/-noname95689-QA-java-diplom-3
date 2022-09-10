package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {

    //Кнопка "Личный Кабинет" в шапке.
    private SelenideElement profileButton = $(byXpath(".//a[@href='/account']"));

    //Кнопка "Конструктор" в шапке.
    private SelenideElement constructorButton = $(byXpath("//*[contains(text(),'Конструктор')]"));

    //Логотип "Stellar Burgers" в шапке.
    private SelenideElement logoButton = $(byCssSelector(".AppHeader_header__logo__2D0X2"));


    public void clickOnProfileButton() {
        profileButton.scrollIntoView(true).click();
    }

    public SelenideElement getConstructorButton() {
        return constructorButton;
    }

    public SelenideElement getLogoButton() {
        return logoButton;
    }
}
