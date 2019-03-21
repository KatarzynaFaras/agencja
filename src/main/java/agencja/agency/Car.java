package agencja.agency;

public class Car {

    private String brand;
    private double engineCapacity;

    public Car(String brand, double engineCapacity) {

        this.brand = brand;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Marka samochodu: " + "\n"
                + "                  " + brand + ", pojemność silnika: " + engineCapacity;
    }

    public double getPojemnosc() {
        return engineCapacity;
    }
}

