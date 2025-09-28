import Cars.Car;
import Repository.CarRepository;
import Repository.CarRepositoryFileImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Загружаем репозиторий из ресурса cars.json
        CarRepository repository = new CarRepositoryFileImpl("cars.json");

        // Получаем все машины
        List<Car> cars = repository.findAll();

        System.out.println("Загружено автомобилей: " + cars.size());
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}