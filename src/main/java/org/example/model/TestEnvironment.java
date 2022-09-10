package org.example.model;

import static com.codeborne.selenide.Selenide.open;

public class TestEnvironment {

    String urlMainPage = "https://stellarburgers.nomoreparties.site/";

    String browser = "Firefox";

    public String getUrlMainPage() {
        return urlMainPage;
    }

    public String getBrowser() {
        return browser;
    }
}
