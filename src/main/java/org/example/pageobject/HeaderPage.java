package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {

    //Кнопка "Личный Кабинет" в шапке.
    private SelenideElement profileButton = $(byXpath(".//p[text()='Личный Кабинет']"));

    public void clickOnProfileButton() {
        profileButton.click();
    }


}
