package HomeWorks.HomeWork10;


import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        //Проверка на чётность
        int[] array = {10, 5, 6, 3};

        int[] result = Sequence.filter(array, number -> number % 2 == 0);

        System.out.print("Чётные числа числа: ");
        System.out.println(Arrays.toString(result));
        System.out.println();

        //Проверка на чётную сумму каждого элемента
        int[] sumResult = Sequence.filter(array, number -> {
            int sum = 0;
            int n = Math.abs(number); // Учитываем отрицательные числа
            while (n != 0) {
                sum += n % 10; // Берём последнюю цифру
                n /= 10;       // Удаляем последнюю цифру
            }
            return sum % 2 == 0;
        });
        System.out.print("Чётная сумма элементов: ");
        System.out.println(Arrays.toString(sumResult));
        System.out.println();

        //Работа с generic-ами
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Pair<Integer, String> pair2 = Pair.of(1, "hello");

        System.out.println("Работа с generic-ами: ");
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair.equals(pair2));
        System.out.println(pair.hashCode() == pair2.hashCode());
    }
}
