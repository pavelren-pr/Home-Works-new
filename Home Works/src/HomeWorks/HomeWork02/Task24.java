package HomeWork.HomeWork02;

import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число строк и столбцов сетки: ");
        int cells = sc.nextInt();
        System.out.println("Введите повторяемый элемент сетки: ");
        String element = sc.next();
        System.out.println("Сетка по запросу "+cells+" на "+cells);
        for (int col = 1; col <= cells; col++) {
            for (int row = 1; row <= cells; row++) {
                System.out.print(element);
            }
            System.out.println("");
        }
    }
}
