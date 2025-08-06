package HomeWorks.HomeWork09.Cars;

import java.util.Arrays;
import java.util.Objects;

public class ShowCar extends Car{

    private int stars;

    public ShowCar(String brand, String model, int manufactureYear, int horsePowers,
                   int acceleration, int suspension, int durability, int stars) {
        super(brand, model, manufactureYear, horsePowers, acceleration, suspension, durability);
        this.stars = stars;
    }

    public ShowCar(int stars) {
        this.stars = stars;
    }

    public ShowCar() {
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", manufactureYear=" + getManufactureYear() +
                ", horsePowers=" + getHorsePowers() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", stars=" + stars +
                '}';
    }
}

