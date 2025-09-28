import Repository.CarRepository;
import Repository.CarRepositoryFileImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryFileImplTest {

    @Test
    void loadCarsFromFile() {
        CarRepository repo = new CarRepositoryFileImpl("cars-test.json");
        assertFalse(repo.findAll().isEmpty(), "Cars must be loaded");
        assertEquals(2, repo.findAll().size());
    }
}