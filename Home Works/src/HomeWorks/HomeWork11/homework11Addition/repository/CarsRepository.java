package HomeWorks.HomeWork11.homework11Addition.repository;

import HomeWorks.HomeWork11.homework11Addition.model.Car;

import java.io.IOException;
import java.util.List;

public interface CarsRepository {
    List<Car> getAllCars() throws IOException;
    void saveToFile(String filename, List<Car> cars) throws IOException;
}
