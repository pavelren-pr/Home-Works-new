package Cars;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {
    private String[] addOns;

    public PerformanceCar() {
        super();
    }

    public PerformanceCar(String brand,
                          String model,
                          int year,
                          int horsePower,
                          int acceleration,
                          int suspension,
                          int durability,
                          String[] addOns) {
        // родительский конструктор
        super(brand, model, year, horsePower, acceleration, suspension, durability);
        this.addOns = addOns;
    }

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", horsePower=" + getHorsePower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", addOns=" + Arrays.toString(addOns) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerformanceCar)) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Arrays.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addOns));
    }
}
