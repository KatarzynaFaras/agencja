package agencja;

public class UbezpieczonyIMPL extends AbstractCzlowiek implements Ubezpieczony {

    Samochod samochod;

    public UbezpieczonyIMPL(String imie, String nazwisko, int wiek, String marka, double pojemnoscSilnika) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.samochod = new Samochod(marka, pojemnoscSilnika);
    }

    public String toString() {
        return "Ubezpieczony: " + "\n"
                + "                  " + imie + " " + nazwisko + " , wiek: " + wiek + "\n" + getPojazd();
    }

    public Samochod getPojazd() {
        return samochod;
    }
}
