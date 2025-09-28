package Cars;

import java.util.Objects;

public class ShowCar extends Car {
    private int stars;

    public ShowCar() {
        super();
    }

    public ShowCar(String brand,
                   String model,
                   int year,
                   int horsePower,
                   int acceleration,
                   int suspension,
                   int durability,
                   int stars) {
        super(brand, model, year, horsePower, acceleration, suspension, durability);
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", horsePower=" + getHorsePower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", stars=" + stars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowCar)) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}