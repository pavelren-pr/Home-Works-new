package HomeWork.HomeWork01;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
               Правила игры.\s
               Доступны для ввода значения:\s
               0 - камень\s
               1 - ножницы\s
               2 - бумага\s
              
               Ходит первый игрок:""");
        int x = sc.nextInt();
        System.out.println("\nХодит второй игрок:");
        int y = sc.nextInt();
        if (x == y) {
            System.out.println("\n- НИЧЬЯ!!!");
        } else if ((y - x) == 1 || x == 2) {
            System.out.println("\n- ПОБЕДИЛ ПЕРВЫЙ ИГРОК!!!");
        } else {
            System.out.println("\n- ПОБЕДИЛ ВТОРОЙ ИГРОК!!!");
        }
    }
}
