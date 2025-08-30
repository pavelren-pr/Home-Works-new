package HomeWorks.HomeWork13.HomeWork13base;

import HomeWorks.HomeWork13.HomeWork13base.utils.NumberUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример работы с целыми
        System.out.print("Введите целое число: ");
        String inputInt = scanner.nextLine();
        Integer resultInt = NumberUtils.validateCount(inputInt);
        if (resultInt != null) {
            System.out.println("Вы ввели число: " + resultInt);
        }

        // Пример работы с дробными
        System.out.print("Введите дробное число: ");
        String inputDouble = scanner.nextLine();
        Double resultDouble = NumberUtils.validateNumber(inputDouble);
        if (resultDouble != null) {
            System.out.println("Вы ввели число: " + resultDouble);
        }
    }
}