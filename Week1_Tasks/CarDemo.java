class Car {
    private String make;
    private String model;
    private int year;
    
    private static final String ENGINE_START_MESSAGE = "Engine has started.";

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void startEngine() {
        System.out.println(ENGINE_START_MESSAGE);
    }
}

class ElectricCar extends Car {
    private int batteryRange;

    private static final String CHARGE_MESSAGE = "Battery is being charged.";

    public ElectricCar(String make, String model, int year, int batteryRange) {
        super(make, model, year);
        this.batteryRange = batteryRange;
    }

    public int getBatteryRange() {
        return batteryRange;
    }

    public void setBatteryRange(int batteryRange) {
        this.batteryRange = batteryRange;
    }

    public void chargeBattery() {
        System.out.println(CHARGE_MESSAGE);
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car[] cars = {
            new Car("Toyota", "Camry", 2022),
            new ElectricCar("Tesla", "Model 3", 2023, 350)
        };

        for (Car car : cars) {
            car.startEngine();
        }
    }
}