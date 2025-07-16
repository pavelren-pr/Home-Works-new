package HomeWork.HomeWork05Addition;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.swap;

public class App {

    //Переделаем метод swap шоб всё работало
    private static void swap(Television[] arr, int i, int j) {
        Television temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

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

        // Генерируем случайные ящики в нужных диапазонах
        // Создаём массив для всех ящиков
        Television[] televisions = new Television[10];

        for (int i = 0; i < 5; i++) {

            String[] sources = {"HDMI", "VGA", "TV", "Cable", "USB"};
            String randomSources = sources[(int) (Math.random() * sources.length)]; // Случайный источник из массива
            int randomChannel = 1 + (int) (Math.random() * 100); // Канал от 1 до 100
            int randomVolume = (int) (Math.random() * 101);      // Громкость от 0 до 100

            televisions[i] = new Television(randomSources, randomChannel, randomVolume);
            System.out.println("TV" + (i+4) + " создан со случайными параметрами:");
            System.out.println(televisions[i]);
            System.out.println();
        }

        //Генерируем 9 телевизор с пом конструктора по ум
        Television tv9 = new Television();
        System.out.println("TV9 (конструктор по умолчанию):");
        System.out.println(tv9);
        System.out.println();

        //Генерируем 10 телевизор с пом конструктора по ум для сравнения с 9
        Television tv10 = new Television();
        System.out.println("TV10 (конструктор по умолчанию):");
        System.out.println(tv10);
        System.out.println();

        //Сравним 10 телек с 9
        if (tv9.equals(tv10)) {
            System.out.println("!!!TV9 совпадает с TV10!!!\n");
        } else System.out.println("Они разные (((\n");

        //Собираем все ящики в тот старый массив
        televisions[5] = tv1;
        televisions[6] = tv2;
        televisions[7] = tv3;
        televisions[8] = tv9;
        televisions[9] = tv10;

        //Считываем макс громкость
        System.out.println("А теперь введите максимальное значение приятной для ушек громкости: ");
        int maxVolume = scanner.nextInt();
        System.out.println("\nПриятные для ушек ящики, при громкости "+maxVolume+": \n");

        //Перебираем все ящики в поисках приятных
        int count = 0; //Посчитаем, сколько всего приятных ящиков есть у Даши
        for (int i = 0; i < televisions.length; i++) {
            if (televisions[i].getCurrentVolume() <= maxVolume) {
                count++;
                System.out.println(count+". Отличный вариант с громкостью: "+
                        televisions[i].getCurrentVolume()+"\n"+televisions[i]+"\n");
            }
        }

        //Выводим на экран сколько было найдено приятных ящиков
        if (count > 0) {
            System.out.println("Найдено приятных ящиков: " + count);
        } else System.out.println("К сожалению для Вас нет приятных ящиков при громкости "+maxVolume+" (((");

        //Проверяем какие из них ещё и включены
        System.out.println("\nИз них включены: ");
        int countOn = 0; //Посчитаем, сколько всего приятных ящиков есть у Даши
        for (int i = 0; i < televisions.length; i++) {
            if (televisions[i].getCurrentVolume() <= maxVolume && televisions[i].isOn()) {
                countOn++;
                System.out.println(countOn+". Прекрасный вариант с громкостью: "+
                        televisions[i].getCurrentVolume()+" и даже включенный:\n"+televisions[i]+"\n");
            }
        }
        System.out.println("Итого идеальных телевизора: "+countOn+"\n");

        //Теперь отсортируем все ящики из массива по порядочку
        for (int i = 1; i < televisions.length; i++) {
            if (televisions[i].getCurrentChannel() < televisions[i - 1].getCurrentChannel()) {
                swap(televisions, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (televisions[z].getCurrentChannel() < televisions[z - 1].getCurrentChannel()) {
                        swap(televisions, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }

        //И выведем их значения
        System.out.println("Все телевизоры в сортировОчке по номеру канала: \n");
        for (int i = 0; i < televisions.length; i++) {
            System.out.println((i+1)+". "+televisions[i].toString());
        }

    }
}
