package HomeWork.HomeWork06;

import java.util.Arrays;
import java.util.Objects;

public class Person {

    private String name;

    private double money;

    private Product[] products;

    private int count;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new Product[10];
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("!!! Имя не может быть пустым !!!");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("!!! Деньги не могут быть отрицательными !!!");
        }
        this.money = money;
    }

    public void getProducts() {
        for (Product bag : products) {
            System.out.println(bag);
        }
    }

    public void addProduct(Product product) {
        if (money >= product.getCost()) {
            if (count == products.length) {
                products = Arrays.copyOf(products, products.length * 2);
            }
            products[count] = product;
            count++;
            money -= product.getCost();
            System.out.println(name + " купил(а) " + product.getName() + ". Остаток денег: " + money);
        } else {
            System.out.println(name + " не может позволить себе " + product.getName() +
                    ". Стоимость продукта: " + product.getCost() + ". Доступные деньги: " +
                    money);
        }
    }

    public int getProductCount() {
        return count;
    }

    public Product[] getProductsArray() {
        return Arrays.copyOf(products, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(money, person.money) == 0 &&
                Objects.equals(name, person.name) && Objects.deepEquals(products, person.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, Arrays.hashCode(products));
    }

    @Override
    public String toString() {
        if (count == 0) {
            return name + " - Ничего не куплено";
        } else return name + " - " + Arrays.toString(getProductsArray());
    }
}