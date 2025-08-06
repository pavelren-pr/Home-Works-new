package HomeWorks.HomeWork09.Races;

import HomeWorks.HomeWork09.Cars.Car;

import java.util.Arrays;
import java.util.Objects;

public class TimeLimitRace extends Race{

    private int goldTime;

    public TimeLimitRace(int distance, String route, int prize, Car[] members, int goldTime) {
        super(distance, route, prize, members);
        this.goldTime = goldTime;
    }

    public int getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TimeLimitRace that = (TimeLimitRace) o;
        return goldTime == that.goldTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), goldTime);
    }

    @Override
    public String toString() {
        return "TimeLimitRace{" +
                "distance=" + getDistance() +
                ", route='" + getRoute() + '\'' +
                ", prize=" + getPrize() +
                ", members=" + Arrays.toString(getMembers()) +
                ", goldTime=" + goldTime +
                '}';
    }
}
