package HomeWorks.HomeWork09.Cars;

import java.util.Objects;

public class Car {

    private String brand;

    private String model;

    private int manufactureYear;

    private int horsePowers;

    private int acceleration;

    private int suspension;

    private int durability;

    public Car(String brand, String model, int manufactureYear, int horsePowers, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.horsePowers = horsePowers;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getHorsePowers() {
        return horsePowers;
    }

    public void setHorsePowers(int horsePowers) {
        this.horsePowers = horsePowers;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return manufactureYear == car.manufactureYear && horsePowers == car.horsePowers && acceleration == car.acceleration && suspension == car.suspension && durability == car.durability && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, manufactureYear, horsePowers, acceleration, suspension, durability);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", horsePowers=" + horsePowers +
                ", acceleration=" + acceleration +
                ", suspension=" + suspension +
                ", durability=" + durability +
                '}';
    }
}
