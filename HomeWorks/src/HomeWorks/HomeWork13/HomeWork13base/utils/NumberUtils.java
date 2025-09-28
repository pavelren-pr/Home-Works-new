package HomeWorks.HomeWork13.HomeWork13base.utils;

public class NumberUtils {

    // Парсинг целого числа
    public static int parseCount(String value) throws IllegalArgumentException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение: " + value);
        }
    }

    // Валидация целого числа
    public static Integer validateCount(String value) {
        try {
            return parseCount(value);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return null;
        }
    }

    // Парсинг числа с плавающей точкой
    public static double parseNumber(String value) throws IllegalArgumentException {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение: " + value);
        }
    }

    // Валидация числа с плавающей точкой
    public static Double validateNumber(String value) {
        try {
            return parseNumber(value);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return null;
        }
    }
}
