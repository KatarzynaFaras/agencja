package agencja;

public class Samochod {

    private String marka;
    private double pojemnoscSilnika;

    public Samochod(String marka, double pojemnoscSilnika) {

        this.marka = marka;
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    @Override
    public String toString() {
        return "Marka samochodu: " + "\n"
                + "                  " + marka + ", pojemność silnika: " + pojemnoscSilnika;
    }

    public double getPojemnosc() {
        return pojemnoscSilnika;
    }
}

