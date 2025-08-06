package HomeWorks.HomeWork09.Races;

import HomeWorks.HomeWork09.Cars.Car;

import java.util.Arrays;
import java.util.Objects;

public class Race {

    private int distance;

    private String route;

    private int prize;

    private Car[] members;

    public Race(int distance, String route, int prize, Car[] members) {
        this.distance = distance;
        this.route = route;
        this.prize = prize;
        this.members = members;
    }

    public Race() {
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public Car[] getMembers() {
        return members;
    }

    public void setMembers(Car[] members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return distance == race.distance && prize == race.prize &&
                Objects.equals(route, race.route) && Objects.deepEquals(members, race.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, route, prize, Arrays.hashCode(members));
    }

    @Override
    public String toString() {
        return "Race{" +
                "distance=" + distance +
                ", route='" + route + '\'' +
                ", prize=" + prize +
                ", members=" + Arrays.toString(members) +
                '}';
    }
}
