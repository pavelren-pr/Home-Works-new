package HomeWork.HomeWork04;

import java.util.Scanner;

public class Task41 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите букву с клавиатуры:");
        String symb = sc.next();
        char fSymb = symb.toLowerCase().charAt(0);


        String Array = "qwertyuiopasdfghjklzxcvbnm";

        if (Array.indexOf(fSymb) != 0) {
            System.out.println(Array.charAt(Array.indexOf(fSymb)-1));
        }   else System.out.println(Array.charAt(Array.length()-1));

        /* Поиск через массив (ТОЖЕ РАБОТАЕТ)
            char[] inputArray = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f',
                             'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == fSymb) {
                if (i != 0) {
                    System.out.println(inputArray[i - 1]);
                } else System.out.println(inputArray[0]);
                break;
            }
         */
    }
}