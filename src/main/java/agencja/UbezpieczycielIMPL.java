package agencja;

public class UbezpieczycielIMPL extends AbstractCzlowiek implements Ubezpieczyciel {

    double stawkaBazowa;
    double znizkaZaWiek;
    double zwyzkaZaWiek;

    public UbezpieczycielIMPL(String imie, String nazwisko, double stawkaBazowa, double znizkaZaWiek, double zwyzkaZaWiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stawkaBazowa = stawkaBazowa;
        this.znizkaZaWiek = znizkaZaWiek;
        this.zwyzkaZaWiek = zwyzkaZaWiek;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }

    public Double wyliczOC(Ubezpieczony ubezpieczony) {
        double stawka = this.stawkaBazowa;
        int wiekUbezp = ubezpieczony.getWiek();
        double pojemnosc = ubezpieczony.getPojazd().getPojemnosc();

        if ((wiekUbezp >= 18) && (wiekUbezp < 25)) {
            stawka = stawka * zwyzkaZaWiek;
        } else if (wiekUbezp > 45) {
            stawka = stawka * znizkaZaWiek;
        }
        if (pojemnosc < 2) {
            stawka = stawka * 0.95;
        } else if (pojemnosc > 3) {
            stawka = stawka * 1.25;
        }
        return stawka;
    }
}

