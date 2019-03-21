package agencja.agency;

public class InsuranceAgentImpl implements InsuranceAgent {

    String name;
    String lastName;
    double baseRate;
    double discountDependsOnAge;
    double increaseDependsOnAge;

    public InsuranceAgentImpl(String name, String lastName, double baseRate, double discountDependsOnAge, double increaseDependsOnAge) {
        this.name = name;
        this.lastName = lastName;
        this.baseRate = baseRate;
        this.discountDependsOnAge = discountDependsOnAge;
        this.increaseDependsOnAge = increaseDependsOnAge;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

    public Double calculateOc(Policyholder ubezpieczony) {
        double rate = this.baseRate;
        int ageOfPolicyholder = ubezpieczony.getAge();
        double capacity = ubezpieczony.getVehicle().getPojemnosc();

        if ((ageOfPolicyholder >= 18) && (ageOfPolicyholder < 25)) {
            rate = rate * increaseDependsOnAge;
        } else if (ageOfPolicyholder > 45) {
            rate = rate * discountDependsOnAge;
        }
        if (capacity < 2) {
            rate = rate * 0.95;
        } else if (capacity > 3) {
            rate = rate * 1.25;
        }
        return rate;
    }
}

