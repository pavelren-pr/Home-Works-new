package HomeWorks.HomeWork11.homework11Addition.test;

import HomeWorks.HomeWork11.homework11Addition.model.Car;
import HomeWorks.HomeWork11.homework11Addition.repository.CarsRepository;
import HomeWorks.HomeWork11.homework11Addition.repository.CarsRepositoryImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CarsRepository repository = new CarsRepositoryImpl("C:/Users/Павел/Documents/GitHub/Home-Works-new/Home Works/src/HomeWorks/HomeWork11/homework11Addition/data/cars.txt");
        List<Car> cars;

        try {
            cars = repository.getAllCars();
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
            return;
        }

        StringBuilder output = new StringBuilder();

        // Вывод таблицы
        output.append("Автомобили в базе:\n");
        output.append(String.format("%-7s %-10s %-8s %-10s %-10s%n",
                "Number", "Model", "Color", "Mileage", "Cost"));
        cars.forEach(c -> output.append(c).append("\n"));

        // Условие поиска
        String colorToFind = "Black";
        long mileageToFind = 0L;
        long n = 700_000L, m = 800_000L;
        String modelToFind1 = "Toyota";
        String modelToFind2 = "Volvo";

        // 1) Номера авто по цвету или пробегу
        List<String> filteredNumbers = cars.stream()
                .filter(c -> c.getColor().equalsIgnoreCase(colorToFind) || c.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.toList());

        output.append("\nНомера автомобилей по цвету или пробегу: ")
                .append(filteredNumbers).append("\n");

        // 2) Количество уникальных моделей в диапазоне цен
        long uniqueModels = cars.stream()
                .filter(c -> c.getCost() >= n && c.getCost() <= m)
                .map(Car::getModel)
                .distinct()
                .count();
        output.append("Уникальные автомобили: ").append(uniqueModels).append(" шт.\n");

        // 3) Цвет авто с минимальной стоимостью
        cars.stream()
                .min(Comparator.comparingLong(Car::getCost))
                .ifPresent(c -> output.append("Цвет автомобиля с минимальной стоимостью: ")
                        .append(c.getColor()).append("\n"));

        // 4) Средняя стоимость моделей
        output.append(printAveragePrice(cars, modelToFind1));
        output.append(printAveragePrice(cars, modelToFind2));

        // --- Запись результата в файл ---
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Павел/Documents/GitHub/Home-Works-new/Home Works/src/HomeWorks/HomeWork11/homework11Addition/data/output.txt"))) {
            writer.write(output.toString());
            System.out.println("✅ Результат сохранён в output.txt");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }

    private static String printAveragePrice(List<Car> cars, String model) {
        OptionalDouble avg = cars.stream()
                .filter(c -> c.getModel().equalsIgnoreCase(model))
                .mapToLong(Car::getCost)
                .average();

        double value = avg.isPresent() ? avg.getAsDouble() : 0.0;
        return String.format("Средняя стоимость модели %s: %.2f%n", model, value);
    }
}