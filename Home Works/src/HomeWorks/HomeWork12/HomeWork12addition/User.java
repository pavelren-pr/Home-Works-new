package HomeWorks.HomeWork12.HomeWork12addition;

import HomeWorks.HomeWork12.HomeWork12addition.exceptions.WrongLoginException;
import HomeWorks.HomeWork12.HomeWork12addition.exceptions.WrongPasswordException;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Метод проверки
    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            // Проверка логина
            if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Логин некорректный: " + login);
            }

            // Проверка пароля
            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Пароль некорректный: " + password);
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }

            return true; // если всё верно

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false; //  при ошибке
        }
    }
}
