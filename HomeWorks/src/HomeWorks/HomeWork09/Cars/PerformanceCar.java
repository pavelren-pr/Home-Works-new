package HomeWorks.HomeWork09.Cars;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {
    private String[] addOns;

    public PerformanceCar(String brand, String model, int manufactureYear, int horsePowers, int acceleration,
                   int suspension, int durability, String[] addOns) {
        super(brand, model, manufactureYear, (int) (horsePowers * 1.5), acceleration, (int) (suspension * 0.75),
                durability);
        this.addOns = addOns;
    }

    public PerformanceCar(String[] addOns) {
        this.addOns = addOns;
    }

    public PerformanceCar() {
    }

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public void setHorsePowers(int horsePowers) {
        super.setHorsePowers((int) (horsePowers * 1.5));
    }

    @Override
    public void setSuspension(int suspension) {
        super.setSuspension((int) (suspension * 0.75));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Objects.deepEquals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addOns));
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "brand='" + super.getBrand() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", manufactureYear=" + super.getManufactureYear() +
                ", horsePowers=" + super.getHorsePowers() +
                ", acceleration=" + super.getAcceleration() +
                ", suspension=" + super.getSuspension() +
                ", durability=" + super.getDurability() +
                "addOns=" + Arrays.toString(addOns) +
                '}';
    }
}
