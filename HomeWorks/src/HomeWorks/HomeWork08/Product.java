package HomeWorks.HomeWork08;

import java.util.Objects;

public class Product {

    private String name;

    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("!!! Название продукта не может быть пустым !!!");
        }
        if (name.trim().length() < 3) {
            throw new IllegalArgumentException("!!! Название продукта должно содержать не менее 3 символов !!!");
        }
        if (name.trim().matches("\\d+")) {
            throw new IllegalArgumentException("!!! Название продукта не может состоять только из цифр !!!");
        }
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException("!!! Стоимость продукта должна быть положительной !!!");
        }
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeWorks.HomeWork08.Product product = (HomeWorks.HomeWork08.Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    @Override
    public String toString() {
        return name + " = " + cost + "; ";
    }
}
