package agencja.agency;

public class PolicyholderImpl implements Policyholder {

    String name;
    String lastName;
    int age;

    Car car;

    public PolicyholderImpl(String name, String lastName, int age, String brand, double engineCapacity) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.car = new Car(brand, engineCapacity);
    }

    public String toString() {
        return "Ubezpieczony: " + "\n"
                + "                  " + name + " " + lastName + " , wiek: " + age + "\n" + getVehicle();
    }

    public Car getVehicle() {
        return car;
    }

    @Override
    public int getAge() {
        return age;
    }

}
