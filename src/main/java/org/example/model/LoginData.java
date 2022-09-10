package org.example.model;

public class LoginData {

    private final String email;
    private final String password;

    public LoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static LoginData getCorrectLoginData() {
        return new LoginData(
                "test958745@yandex.ru",
                "qwerty"
        );
    }

    public static LoginData getShortPasswordLoginData() {
        return new LoginData(
                "test958745@yandex.ru",
                "qwert"
        );
    }


}
