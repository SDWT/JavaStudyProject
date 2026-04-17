package Module1;

public class Car {

    private String brand;
    private String model;
    private int year;
    private double price;
    private boolean isElectric;

    public Car(String brand, String model, int year, double price, boolean isElectric) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isElectric = isElectric;
    }

    // Copy constructor
    public Car(Car other) {
        this.brand = other.brand;
        this.model = other.model;
        this.year = other.year;
        this.price = other.price;
        this.isElectric = other.isElectric;
    }

    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public boolean isElectric() { return isElectric; }

    // Output
    @Override
    public String toString() {
        return String.format("%s %s (%d) $%.2f Electric: %s", brand, model, year, price, 
            //(isElectric ? "✅" : "❌")
            //(isElectric ? "✔" : "✖") // not all terminal supports symbols            
            (isElectric ? "Y" : "n")
        );
    }
}