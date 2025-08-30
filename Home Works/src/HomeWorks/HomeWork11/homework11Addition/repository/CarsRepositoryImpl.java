package HomeWorks.HomeWork11.homework11Addition.repository;

import HomeWorks.HomeWork11.homework11Addition.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarsRepositoryImpl implements CarsRepository {

    private final String filename;

    public CarsRepositoryImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Car> getAllCars() throws IOException {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String number = parts[0];
                    String model = parts[1];
                    String color = parts[2];
                    long mileage = Long.parseLong(parts[3]);
                    long cost = Long.parseLong(parts[4]);
                    cars.add(new Car(number, model, color, mileage, cost));
                }
            }
        }
        return cars;
    }

    @Override
    public void saveToFile(String filename, List<Car> cars) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                writer.write(String.format("%s|%s|%s|%d|%d",
                        car.getNumber(), car.getModel(), car.getColor(),
                        car.getMileage(), car.getCost()));
                writer.newLine();
            }
        }
    }
}
