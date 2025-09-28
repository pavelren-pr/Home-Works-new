package HomeWorks.HomeWork09;

import HomeWorks.HomeWork09.Cars.Car;
import HomeWorks.HomeWork09.Cars.PerformanceCar;
import HomeWorks.HomeWork09.Cars.ShowCar;

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

        StringBuilder menu = new StringBuilder("Выберите параметр для модификации: \n");
        menu.append("Мощность - 1\n");
        menu.append("Ускорение - 2\n");
        menu.append("Подвеска - 3\n");
        menu.append("Долговечность - 4\n");

        if (car instanceof PerformanceCar) {
            menu.append("Дополнения - 5\n");
            menu.append("Внимание: для PerformanceCar мощность увеличивается на 50%, подвеска уменьшается на 25%\n");
        } else if (car instanceof ShowCar) {
            menu.append("Звезды - 5\n");
        }

        System.out.println(menu.toString());
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        switch (scanner.nextInt()) {
            case 1 -> {
                System.out.print("Текущее значение: " + car.getHorsePowers());
                if (car instanceof PerformanceCar) {
                    System.out.print(" (базовое: " + (int)(car.getHorsePowers() / 1.5) + ")");
                }
                System.out.print("\nВведите новое значение - ");
                car.setHorsePowers(scanner.nextInt());
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
            case 5 -> {
                if (car instanceof PerformanceCar) {
                    System.out.print("Текущие дополнения: " + Arrays.toString(((PerformanceCar) car).getAddOns()) +
                            "\nВведите новые дополнения (через запятую) - ");
                    String[] newAddOns = scanner.nextLine().split("\\s*,\\s*");
                    ((PerformanceCar) car).setAddOns(newAddOns);
                } else if (car instanceof ShowCar) {
                    System.out.print("Текущее количество звезд: " + ((ShowCar) car).getStars() +
                            "\nВведите новое количество - ");
                    ((ShowCar) car).setStars(scanner.nextInt());
                } else {
                    System.out.println("Ошибка: неверный тип автомобиля");
                }
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
