package racingcar;

public class Car {
    private final CarName name;
    final CarLocation location;

    public Car(String name) {
        this.name = new CarName(name);
        this.location = new CarLocation();
    }

    public String getName() {
        return name.getName();
    }

    public String location() {
        return location.getLocation().toString();
    }
}
