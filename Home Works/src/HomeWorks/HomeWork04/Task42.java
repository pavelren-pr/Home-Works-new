package HomeWork.HomeWork04;

import java.util.Scanner;

import static java.lang.Math.random;

public class Task42 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Выберете метод ввода стрелок: \n 1 - ручной ввод \n 2 - автоматический ввод");

        int choose = sc.nextInt();
        sc.nextLine();

        String finalLine = "";

        // Выбор метода записи последовательности символов
        switch (choose) {

            case 1:

                System.out.println("Введите строку с символами \"-\", \"<\", \">\": ");
                finalLine = sc.nextLine();
                break;

            case 2:

                System.out.println("Введите желаемое количество символов в строке: ");
                int length = sc.nextInt();
                char[] randLine = new char[length];
                char[] elements = {'-', '>', '<'};

                for (int i = 0; i < length; i++) {
                    int element = (int) (random() * 3);
                    randLine[i] = elements[element];
                }

                finalLine = new String(randLine);
                break;

            default:
                System.out.println("Ввод неверный");
                break;

        }

        // Выводим строку
        System.out.println(finalLine);

        int counter = 0;

        // Поиск стрелок типа ">>-->"
        int lastIndex = 0;
        while (lastIndex != -1) {
            int pos = finalLine.indexOf(">>-->", lastIndex);
            if (pos == -1) break;
            counter++;
            lastIndex = pos + 1;
        }

        // Поиск стрелок типа "<--<<"
        lastIndex = 0;
        while (lastIndex != -1) {
            int pos = finalLine.indexOf("<--<<", lastIndex);
            if (pos == -1) break;
            counter++;
            lastIndex = pos + 1;
        }

        System.out.println("Найдено стрел: " + counter);
    }
}
