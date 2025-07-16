package HomeWork.HomeWork02;

import java.util.Scanner;

public class Task23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String words = sc.nextLine();
        System.out.println("Сколько раз вывести строку "+words+"?");
        int count = sc.nextInt();
        System.out.print("После повторения "+count+" раз: ");
        for (int i = 1; i <= count; i++) {
            System.out.print(words);
        }
    }
}
