package HomeWorks.HomeWork09;

import HomeWorks.HomeWork09.Cars.Car;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Garage {

    private Car[] parkedCars;

    public Garage(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    public Garage() {
    }

    public void modifyCar(int carNumber) {
        Car car = parkedCars[carNumber];
        System.out.println(car.toString());

        System.out.println("Выберите параметр для модификации: \nМощность - 1 \nУскорение - 2 \nПодвеска - 3 " +
                "\nДолговечность - 4 \n");
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        switch (scanner.nextInt()) {
            case 1 -> {
                System.out.print("Текущее значение: " + car.getHorsePowers() + "\nВведите новое значение - ");
                int newHP = scanner.nextInt();
                car.setHorsePowers(newHP);
            }
            case 2 -> {
                System.out.print("Текущее значение: " + car.getAcceleration() + "\nВведите новое значение - ");
                int newAcceleration = scanner.nextInt();
                car.setAcceleration(newAcceleration);
            }
            case 3 -> {
                System.out.print("Текущее значение: " + car.getSuspension() + "\nВведите новое значение - ");
                int newSuspension = scanner.nextInt();
                car.setSuspension(newSuspension);
            }
            case 4 -> {
                System.out.print("Текущее значение: " + car.getDurability() + "\nВведите новое значение - ");
                int newDurability = scanner.nextInt();
                car.setDurability(newDurability);
            }
            default -> System.out.println("Выбран неверный параметр");

        }
    }

    public Car[] getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.deepEquals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(parkedCars);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + Arrays.toString(parkedCars) +
                '}';
    }
}
