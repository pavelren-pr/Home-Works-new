package Repository;

import Cars.Car;
import Cars.PerformanceCar;
import Cars.ShowCar;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarRepositoryFileImpl implements CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public CarRepositoryFileImpl(String resourcePath) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) throw new IllegalArgumentException("Resource not found: " + resourcePath);

            ObjectMapper mapper = new ObjectMapper();

            // Читаем JSON сразу в список Map
            List<java.util.Map<String, Object>> arr = mapper.readValue(is,
                    new TypeReference<List<java.util.Map<String, Object>>>() {});

            for (Map<String, Object> m : arr) {
                String type = (String) m.get("type");
                m.remove("type"); // <- удаляем поле, чтобы Jackson не ругался

                if ("PerformanceCar".equals(type)) {
                    PerformanceCar p = mapper.convertValue(m, PerformanceCar.class);
                    p.setHorsePower((int)(p.getHorsePower() * 1.5));
                    p.setSuspension((int)(p.getSuspension() * 0.75));
                    cars.add(p);
                } else if ("ShowCar".equals(type)) {
                    ShowCar s = mapper.convertValue(m, ShowCar.class);
                    cars.add(s);
                } else {
                    Car c = mapper.convertValue(m, Car.class);
                    cars.add(c);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }

    @Override
    public java.util.Optional<Car> findById(String id) {
        return cars.stream().filter(c -> (c.getBrand() + c.getModel()).equals(id)).findFirst();
    }

    @Override
    public List<Car> findByType(String type) {
        List<Car> res = new ArrayList<>();
        for (Car c : cars) {
            if (type.equalsIgnoreCase(c.getClass().getSimpleName())) res.add(c);
        }
        return res;
    }
}
