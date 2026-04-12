import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class CarHolder {

    private final List<Car> cars;
    private final Date createdDate;

    public CarHolder(List<Car> cars, Date createdDate) {
        // Defensive copy
        List<Car> tempList = new ArrayList<>();
        for (Car car : cars) {
            tempList.add(new Car(car));
        }
        this.cars = tempList;

        // Defensive copy of mutable class Date
        this.createdDate = new Date(createdDate.getTime());
    }

    public List<Car> getCars() {
        // Return copy
        List<Car> copyList = new ArrayList<>();
        for (Car car : cars) {
            copyList.add(new Car(car));
        }
        return copyList;
    }

    public Date getCreatedDate() {
        // Return copy of Date
        return new Date(createdDate.getTime());
    }
}