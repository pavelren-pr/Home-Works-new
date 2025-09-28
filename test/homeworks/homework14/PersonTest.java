package homeworks.homework14;

import HomeWorks.HomeWork06.Person;
import HomeWorks.HomeWork06.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testValidPersonCreation() {
        Person person = new Person("Иван", 100);
        assertEquals("Иван", person.getName());
        assertEquals(100, person.getMoney());
    }

    @Test
    void testSetNameValid() {
        Person person = new Person("Анна", 200);
        person.setName("Ольга");
        assertEquals("Ольга", person.getName());
    }

    @Test
    void testSetNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", 300));
    }

    @Test
    void testSetMoneyValid() {
        Person person = new Person("Андрей", 1000);
        person.setMoney(500);
        assertEquals(500, person.getMoney());
    }

    @Test
    void testSetMoneyThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Павел", -50));
    }

    @Test
    void testAddProductSuccess() {
        Person person = new Person("Иван", 100);
        Product bread = new Product("Хлеб", 50);

        person.addProduct(bread);

        assertEquals(1, person.getProductCount());
        assertEquals(50, person.getMoney()); // остаток после покупки
    }

    @Test
    void testAddProductNotEnoughMoney() {
        Person person = new Person("Иван", 30);
        Product steak = new Product("Стейк", 100);

        person.addProduct(steak);

        assertEquals(0, person.getProductCount()); // покупка не добавилась
        assertEquals(30, person.getMoney());       // деньги не изменились
    }

    @Test
    void testGetProductsArray() {
        Person person = new Person("Иван", 200);
        Product milk = new Product("Молоко", 40);
        Product butter = new Product("Масло", 60);

        person.addProduct(milk);
        person.addProduct(butter);

        Product[] bought = person.getProductsArray();
        assertArrayEquals(new Product[]{milk, butter}, bought);
    }

    @Test
    void testToStringWhenNoProducts() {
        Person person = new Person("Анна", 100);
        assertEquals("Анна - Ничего не куплено", person.toString());
    }

    @Test
    void testToStringWithProducts() {
        Person person = new Person("Анна", 200);
        Product coffee = new Product("Кофе", 100);
        person.addProduct(coffee);
        assertTrue(person.toString().contains("Кофе"));
    }
}
