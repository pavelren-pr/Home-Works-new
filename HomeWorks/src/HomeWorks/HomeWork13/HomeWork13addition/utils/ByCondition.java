package HomeWorks.HomeWork13.HomeWork13addition.utils;

// Интерфейс с дженериком для проверки чисел
@FunctionalInterface
public interface ByCondition<T extends Number> {
    boolean test(T value);
}