package HomeWorks.HomeWork09;

import HomeWorks.HomeWork09.Cars.Car;
import HomeWorks.HomeWork09.Cars.PerformanceCar;
import HomeWorks.HomeWork09.Cars.ShowCar;
import HomeWorks.HomeWork09.Races.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // 1. Создание автомобилей
        PerformanceCar perfCar = new PerformanceCar(
                "Toyota", "Supra", 2020, 340, 5, 250, 150,
                new String[]{"Турбо", "Спойлер"}
        );

        ShowCar showCar = new ShowCar(
                "Ferrari", "488 GTB", 2021, 660, 3, 350, 200, 5
        );

        // 2. Создание гаража
        Garage garage = new Garage(new Car[]{perfCar, showCar});

        System.out.println("Исходные автомобили в гараже:");
        System.out.println(Arrays.toString(garage.getParkedCars()));

        // 3. Создание гонок
        Car[] raceMembers = {perfCar, showCar};

        Race casualRace = new CasualRace(1000, "Городская трасса", 50000, raceMembers);
        Race dragRace = new DragRace(400, "Прямая дорога", 30000, raceMembers);
        Race driftRace = new DriftRace(2000, "Горный серпантин", 75000, raceMembers);
        TimeLimitRace timeRace = new TimeLimitRace(5000, "Кольцевая трасса", 100000, raceMembers, 180);
        CircuitRace circuitRace = new CircuitRace(3000, "Национальное кольцо", 150000, raceMembers, 5);

        // 4. Вывод информации о гонках
        System.out.println("\nИнформация о гонках:");
        System.out.println(casualRace);
        System.out.println(dragRace);
        System.out.println(driftRace);
        System.out.println(timeRace);
        System.out.println(circuitRace);

        // 5. Демонстрация модификации
        System.out.println("\nМодификация PerformanceCar: ");
        garage.modifyCar(0);

        System.out.println("\nРезультат модификации: ");
        System.out.println(perfCar);
    }
}