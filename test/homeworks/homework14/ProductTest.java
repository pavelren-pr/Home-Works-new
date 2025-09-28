package homeworks.homework14;

import HomeWorks.HomeWork06.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testValidProductCreation() {
        Product p = new Product("Хлеб", 50);
        assertEquals("Хлеб", p.getName());
        assertEquals(50, p.getCost());
    }

    @Test
    void testSetNameValid() {
        Product p = new Product("Молоко", 70);
        p.setName("Кефир");
        assertEquals("Кефир", p.getName());
    }

    @Test
    void testSetNameThrowsException() {
        Product p = new Product("Сыр", 100);
        assertThrows(IllegalArgumentException.class, () -> p.setName(""));
    }

    @Test
    void testSetCostValid() {
        Product p = new Product("Сок", 30);
        p.setCost(45);
        assertEquals(45, p.getCost());
    }

    @Test
    void testSetCostThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Чай", -10));
    }

    @Disabled("Пример игнорирования теста")
    @Test
    void testDisabledExample() {
        fail("Этот тест не должен выполниться");
    }
}
