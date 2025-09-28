package HomeWorks.HomeWork13.HomeWork13addition;

import HomeWorks.HomeWork13.HomeWork13addition.utils.ByCondition;
import HomeWorks.HomeWork13.HomeWork13addition.utils.Sequence;

public class Main {
    public static void main(String[] args) {
        // Условие: число должно быть положительным
        ByCondition<Integer> positiveInt = val -> val > 0;
        ByCondition<Double> positiveDouble = val -> val > 0;

        Sequence<Integer> intSeq = new Sequence<>(positiveInt);
        Sequence<Double> doubleSeq = new Sequence<>(positiveDouble);

        // Пример чисел
        intSeq.add(10);
        intSeq.add(-5);
        intSeq.add(42);

        doubleSeq.add(3.14);
        doubleSeq.add(-7.2);
        doubleSeq.add(0.5);

        System.out.println("Допущенные целые: " + intSeq.getValues());
        System.out.println("Допущенные дробные: " + doubleSeq.getValues());
    }
}
