package org.example.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    //Кнопка "Выход"
    private SelenideElement exitButton = $(byXpath(".//button[text()='Выход']"));

    public SelenideElement getExitButton() {
        return exitButton;
    }
}
