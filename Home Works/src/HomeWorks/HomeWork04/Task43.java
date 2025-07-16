package HomeWork.HomeWork04;

import java.util.Arrays;
import java.util.Scanner;

public class Task43 {

    // Создаём метод сортировки отдельного слова
    public static String sortString(String tempString)
    {
        char tempArray[] = tempString.toCharArray();

        Arrays.sort(tempArray);

        return new String(tempArray);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите последовательности символов буквами латинского алфавита: ");
        String input = sc.nextLine().toLowerCase(); // Принимаем ввод
        String[] divided = input.split(" "); // Разделяем ввод в массив
        System.out.println("Отсортированная строка: ");

        // Сортируем каждый элемент массива при помощи метода и тут же выводим его
        for (String tempString : divided) {
            System.out.print(sortString(tempString)+" ");

        }
    }
}

