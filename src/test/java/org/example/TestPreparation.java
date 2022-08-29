package org.example;

import com.codeborne.selenide.Selenide;

public class TestPreparation {

    public static String getAccessToken() {
        String accessToken = Selenide.localStorage().getItem("accessToken");
        return accessToken;
    }
}
