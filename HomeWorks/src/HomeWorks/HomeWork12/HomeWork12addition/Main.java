package HomeWorks.HomeWork12.HomeWork12addition;

public class Main {
    public static void main(String[] args) {
        // Тестовые проверки
        System.out.println(User.validate("user_123", "pass_123", "pass_123")); // ✅ true
        System.out.println(User.validate("bad login!", "pass123", "pass123")); // ❌ false (логин с пробелом)
        System.out.println(User.validate("validUser", "bad-pass", "bad-pass")); // ❌ false (недопустимый символ)
        System.out.println(User.validate("validUser", "password1", "password2")); // ❌ false (пароли разные)
        System.out.println(User.validate("toolongloginusernametext", "pass123", "pass123")); // ❌ false (логин > 20 символов)
    }
}