package HomeWork.HomeWork02;

import java.util.Scanner;

public class Task22 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите 1-е целое число: ");
            int first = sc.nextInt();
            System.out.println("Введите второе целое число: ");
            int second = sc.nextInt();
            System.out.println("Сумма двух целых чисел: "+(first+second));
            System.out.println("Разница двух целых чисел: "+(first-second));
            System.out.println("Произведение из двух целых чисел: "+(first*second));
            System.out.println("Среднее из двух целых чисел: "+((first+second)*0.5));
            System.out.println("Расстояние двух целых чисел: "+(Math.max(first, second)-Math.min(first, second)));
            System.out.println("Максимальное целое число: "+Math.max(first, second));
            System.out.println("Минимальное целое число: "+Math.min(first, second));
        }


}
