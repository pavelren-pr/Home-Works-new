package HomeWork.HomeWork02;

import java.util.Scanner;

public class Task21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите температуру в градусах Фарангейта:");
        double farenheit = sc.nextDouble();
        double cels = (farenheit - 32)/1.8;
        System.out.println(farenheit+" градусов Фаренгейта равняется "+cels+" по Цельсию");
    }

}
