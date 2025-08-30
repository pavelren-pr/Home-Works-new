package HomeWorks.HomeWork13.HomeWork13addition.utils;

import java.util.ArrayList;
import java.util.List;

public class Sequence<T extends Number> {
    private List<T> values = new ArrayList<>();
    private ByCondition<T> condition;

    public Sequence(ByCondition<T> condition) {
        this.condition = condition;
    }

    public void add(T value) {
        if (condition.test(value)) {
            values.add(value);
        } else {
            System.out.println("Значение " + value + " отклонено условием.");
        }
    }

    public List<T> getValues() {
        return values;
    }
}
