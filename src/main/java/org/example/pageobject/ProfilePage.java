package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    //Кнопка выхода из профиля
    private SelenideElement exitProfileButton = $(byXpath(".//button[text()='Выход']"));

    public SelenideElement getExitProfileButton() {
        exitProfileButton.scrollIntoView(true);
        return exitProfileButton;
    }
}
