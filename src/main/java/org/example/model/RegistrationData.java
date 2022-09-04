package org.example.model;

import org.example.pageobject.RegistrationPage;

public class RegistrationData {

    private final String name;
    private final String email;
    private final String password;

    public RegistrationData(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static RegistrationData getCorrectRegistrationData() {
        return new RegistrationData(
                "Test",
                "test958745@yandex.ru",
                "qwerty"
        );
    }

    public static RegistrationData getShortPasswordRegistrationData() {
        return new RegistrationData(
                "Test",
                "test958745@yandex.ru",
                "qwerty"
        );
    }
}
