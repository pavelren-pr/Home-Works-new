package HomeWork.HomeWork03;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // === Часть 1: Проверка базовой функциональности ===
        // Создаем телевизор с помощью конструктора по умолчанию
        Television tv1 = new Television();
        System.out.println("TV1 после создания (конструктор по умолчанию):");
        System.out.println(tv1); // Автоматически вызовется tv1.toString()
        System.out.println(); // Пустая строка

        // Включаем TV1, меняем канал и громкость
        tv1.turnOn();
        tv1.setCurrentChannel(5);
        tv1.setCurrentVolume(30);
        System.out.println("TV1 после включения и настройки:");
        System.out.println(tv1);
        System.out.println();

        // Создаем телевизор с помощью конструктора с параметрами
        Television tv2 = new Television("Net", 10, 25);
        tv2.turnOn(); // Включаем его
        System.out.println("TV2 после создания (конструктор с параметрами) и включения:");
        System.out.println(tv2);
        System.out.println();

        // Проверяем методы поведения
        tv1.nextChannel();
        tv1.increaseVolume();
        System.out.println("TV1 после nextChannel и increaseVolume:");
        System.out.println(tv1);
        System.out.println();

        // Проверяем сеттеры с НЕДОПУСТИМЫМИ значениями (должны сработать проверки)
        tv2.setCurrentVolume(150); // >100
        tv2.setCurrentChannel(-5); // <1
        System.out.println("TV2 после попыток установить громкость=150 и канал=-5:");
        System.out.println(tv2); // Значения должны остаться прежними (25 и 10)
        System.out.println();

        // === Дополнительно: Ввод с клавиатуры ===
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для чтения с клавиатуры

        System.out.println("=== Создание TV3 (данные с клавиатуры) ===");
        Television tv3 = new Television(); // Создаем пустой телевизор

        System.out.print("Введите источник: ");
        String sour = scanner.nextLine(); // Читаем строку
        tv3.setSource(sour); // Устанавливаем

        System.out.print("Введите начальный канал (целое число > 0): ");
        int channel = scanner.nextInt(); // Читаем целое число
        tv3.setCurrentChannel(channel); // Устанавливаем (сеттер проверит)

        System.out.print("Введите начальную громкость (целое число 0-100): ");
        int volume = scanner.nextInt(); // Читаем целое число
        tv3.setCurrentVolume(volume); // Устанавливаем (сеттер проверит)

        tv3.turnOn(); // Включаем
        System.out.println("\nTV3 создан на основе вашего ввода:");
        System.out.println(tv3);
        scanner.nextLine(); // Очистка буфера (после nextInt())
        System.out.println();

        // === Дополнительно: Случайные числа ===
        System.out.println("=== Создание TV4 (случайные параметры) ===");
        // Генерируем случайные значения в нужных диапазонах
        String[] sources = {"HDMI", "VGA", "TV", "Cable", "USB"};
        String randomSources = sources[(int) (Math.random() * sources.length)]; // Случайный источник из массива
        int randomChannel = 1 + (int) (Math.random() * 100); // Канал от 1 до 100
        int randomVolume = (int) (Math.random() * 101);      // Громкость от 0 до 100

        Television tv4 = new Television(randomSources, randomChannel, randomVolume);
        tv4.turnOn();
        System.out.println("TV4 создан со случайными параметрами:");
        System.out.println(tv4);

    }
}
