package Repository;

import Cars.Car;
import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<Car> findAll();
    Optional<Car> findById(String id); // если нужно идентифицировать авто
    List<Car> findByType(String type);
    // добавьте методы, которые вам нужны по логике приложения
}
