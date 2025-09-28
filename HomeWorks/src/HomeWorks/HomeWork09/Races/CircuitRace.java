package HomeWorks.HomeWork09.Races;

import HomeWorks.HomeWork09.Cars.Car;

import java.util.Arrays;
import java.util.Objects;

public class CircuitRace extends Race{

    private int laps;

    public CircuitRace(int distance, String route, int prize, Car[] members, int laps) {
        super(distance, route, prize, members);
        this.laps = laps;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "CircuitRace{" +
                "distance=" + getDistance() +
                ", route='" + getRoute() + '\'' +
                ", prize=" + getPrize() +
                ", members=" + Arrays.toString(getMembers()) +
                ", laps=" + laps +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CircuitRace that = (CircuitRace) o;
        return laps == that.laps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), laps);
    }
}
