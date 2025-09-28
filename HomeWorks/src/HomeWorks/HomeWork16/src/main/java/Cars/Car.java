package Cars;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int year;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car() {
    }

    public Car(String brand, String model, int year,
               int horsePower, int acceleration,
               int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getHorsePower() { return horsePower; }
    public void setHorsePower(int horsePower) { this.horsePower = horsePower; }

    public int getAcceleration() { return acceleration; }
    public void setAcceleration(int acceleration) { this.acceleration = acceleration; }

    public int getSuspension() { return suspension; }
    public void setSuspension(int suspension) { this.suspension = suspension; }

    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", horsePower=" + horsePower +
                ", acceleration=" + acceleration +
                ", suspension=" + suspension +
                ", durability=" + durability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year &&
                horsePower == car.horsePower &&
                acceleration == car.acceleration &&
                suspension == car.suspension &&
                durability == car.durability &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, horsePower, acceleration, suspension, durability);
    }
}
