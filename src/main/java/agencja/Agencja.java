package agencja;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Agencja {

    private static Set<Ubezpieczyciel> ubezpieczyciele = new HashSet<>();

    private static Set<Ubezpieczony> ubezpieczeni = new HashSet<>();

    public static Map<Ubezpieczyciel, Double> zlozcieOferty(Set<Ubezpieczyciel> ubezpieczyciele, Ubezpieczony ub) {
        Map<Ubezpieczyciel, Double> map = new HashMap<>();
        for (Ubezpieczyciel u : ubezpieczyciele) {
            map.put(u, u.wyliczOC(ub));
        }
        return map;
    }

    public static void znajdzNajlepszaOferte(Ubezpieczony ub) {
        System.out.println(ub);
        Map<Ubezpieczyciel, Double> ofertyDlaUbezpieczonego = zlozcieOferty(ubezpieczyciele, ub);
        Double minValue = ofertyDlaUbezpieczonego.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
        Ubezpieczyciel zNajlepszaOferta = ofertyDlaUbezpieczonego.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("Najniższa oferta: " + "\n"
                + "                  " + minValue + "\n"
                + "                  " + zNajlepszaOferta + "\n"
                + "---------------------------------------------------");
    }

    public static void main(String[] args) {

        Ubezpieczony ubezpieczony1 = new UbezpieczonyIMPL("Mateusz", "Faraś", 32, "AcuraTL", 3.2);
        Ubezpieczony ubezpieczony2 = new UbezpieczonyIMPL("Katarzyna", "Faraś", 33, "Ford", 1.8);
        Ubezpieczony ubezpieczony3 = new UbezpieczonyIMPL("Lesław", "Pietruszka", 60, "Ford", 1.8);
        Ubezpieczony ubezpieczony4 = new UbezpieczonyIMPL("Edward", "Mucha", 18, "Ford", 1.8);
        Ubezpieczony ubezpieczony5 = new UbezpieczonyIMPL("Mariusz", "Ogon", 18, "Fiat", 4.0);

        ubezpieczeni.add(ubezpieczony1);
        ubezpieczeni.add(ubezpieczony2);
        ubezpieczeni.add(ubezpieczony3);
        ubezpieczeni.add(ubezpieczony4);
        ubezpieczeni.add(ubezpieczony5);

        Ubezpieczyciel ubezpieczyciel1 = new UbezpieczycielIMPL("Romuald", "Lorenc", 1000, 0.9, 1.1);
        Ubezpieczyciel ubezpieczyciel2 = new UbezpieczycielIMPL("Tomasz", "Noga", 1050, 0.8, 1.1);
        Ubezpieczyciel ubezpieczyciel3 = new UbezpieczycielIMPL("Dariusz", "Stonoga", 1100, 0.7, 1.5);
        Ubezpieczyciel ubezpieczyciel4 = new UbezpieczycielIMPL("Anna", "Jajko", 950, 0.99, 1.5);

        ubezpieczyciele.add(ubezpieczyciel1);
        ubezpieczyciele.add(ubezpieczyciel2);
        ubezpieczyciele.add(ubezpieczyciel3);
        ubezpieczyciele.add(ubezpieczyciel4);

        for (Ubezpieczony ub : ubezpieczeni) {
            zlozcieOferty(ubezpieczyciele, ub);
            znajdzNajlepszaOferte(ub);
        }
    }
}
