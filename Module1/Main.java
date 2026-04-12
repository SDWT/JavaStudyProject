import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Testing
        // Create data
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Tesla", "Model 3", 2022, 50000, true));
        carList.add(new Car("BMW", "X5", 2021, 70000, false));

        Date now = new Date();

        CarHolder holder = new CarHolder(carList, now);

        // Get data from holder
        List<Car> carsFromHolder = holder.getCars();
        Date dateFromHolder = holder.getCreatedDate();

        System.out.println("Cars in holder:");
        for (Car car : carsFromHolder) {
            System.out.println(car);
        }

        System.out.println("Date: " + dateFromHolder);

        // Try modifying returned data
        carsFromHolder.add(new Car("Audi", "A4", 2020, 40000, false));
        dateFromHolder.setTime(0);

        // Fetch again to verify immutability
        List<Car> carsAgain = holder.getCars();
        Date dateAgain = holder.getCreatedDate();

        System.out.println("\nAfter modification:");
        System.out.println("Cars in holder:");
        for (Car car : carsAgain) {
            System.out.println(car);
        }

        System.out.println("Date: " + dateAgain);
    }
}