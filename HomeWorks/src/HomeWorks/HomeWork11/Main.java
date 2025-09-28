package HomeWorks.HomeWork11;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        CarsRepository repository = new CarsRepositoryImpl();
        List<Car> cars = repository.getAllCars();

        // Вывод таблицы
        System.out.println("Автомобили в базе:");
        System.out.printf("%-7s %-10s %-8s %-10s %-10s%n",
                "Number", "Model", "Color", "Mileage", "Cost");
        cars.forEach(System.out::println);

        // Условие поиска
        String colorToFind = "Black";
        long mileageToFind = 0L;
        long n = 700_000L, m = 800_000L;
        String modelToFind1 = "Toyota";

        // 1) Номера авто по цвету или пробегу
        List<String> filteredNumbers = cars.stream()
                .filter(c -> c.getColor().equalsIgnoreCase(colorToFind) || c.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.toList());

        System.out.println("\nНомера автомобилей по цвету или пробегу: " + filteredNumbers);

        // 2) Количество уникальных моделей в диапазоне цен
        long uniqueModels = cars.stream()
                .filter(c -> c.getCost() >= n && c.getCost() <= m)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("Уникальные автомобили: " + uniqueModels + " шт.");

        // 3) Цвет авто с минимальной стоимостью
        cars.stream()
                .min(Comparator.comparingLong(Car::getCost))
                .ifPresent(c -> System.out.println("Цвет автомобиля с минимальной стоимостью: " + c.getColor()));

        // 4) Средняя стоимость модели
        printAveragePrice(cars, modelToFind1);
    }

    private static void printAveragePrice(List<Car> cars, String model) {
        OptionalDouble avg = cars.stream()
                .filter(c -> c.getModel().equalsIgnoreCase(model))
                .mapToLong(Car::getCost)
                .average();

        double value = avg.isPresent() ? avg.getAsDouble() : 0.0;
        System.out.printf("Средняя стоимость модели %s: %.2f%n", model, value);
    }

}
