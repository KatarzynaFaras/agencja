package agencja.agency;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Agency {

    private static Set<InsuranceAgent> agents = new HashSet<>();

    private static Set<Policyholder> insurers = new HashSet<>();

    public static Map<InsuranceAgent, Double> makeAnOffer(Set<InsuranceAgent> agents, Policyholder ub) {
        Map<InsuranceAgent, Double> map = new HashMap<>();
        for (InsuranceAgent u : agents) {
            map.put(u, u.calculateOc(ub));
        }
        return map;
    }

    public static void findBestOffer(Policyholder ub) {
        System.out.println(ub);
        Map<InsuranceAgent, Double> offersForPolicyholder = makeAnOffer(agents, ub);
        Double minValue = offersForPolicyholder.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
        InsuranceAgent withBestOffer = offersForPolicyholder.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("Najniższa oferta: " + "\n"
                + "                  " + minValue + "\n"
                + "                  " + withBestOffer + "\n"
                + "---------------------------------------------------");
    }

    public static void main(String[] args) {

        Policyholder ubezpieczony1 = new PolicyholderImpl("Mateusz", "Faraś", 32, "AcuraTL", 3.2);
        Policyholder ubezpieczony2 = new PolicyholderImpl("Katarzyna", "Faraś", 33, "Ford", 1.8);
        Policyholder ubezpieczony3 = new PolicyholderImpl("Lesław", "Pietruszka", 60, "Ford", 1.8);
        Policyholder ubezpieczony4 = new PolicyholderImpl("Edward", "Mucha", 18, "Ford", 1.8);
        Policyholder ubezpieczony5 = new PolicyholderImpl("Mariusz", "Ogon", 18, "Fiat", 4.0);

        insurers.add(ubezpieczony1);
        insurers.add(ubezpieczony2);
        insurers.add(ubezpieczony3);
        insurers.add(ubezpieczony4);
        insurers.add(ubezpieczony5);

        InsuranceAgent ubezpieczyciel1 = new InsuranceAgentImpl("Romuald", "Lorenc", 1000, 0.9, 1.1);
        InsuranceAgent ubezpieczyciel2 = new InsuranceAgentImpl("Tomasz", "Noga", 1050, 0.8, 1.1);
        InsuranceAgent ubezpieczyciel3 = new InsuranceAgentImpl("Dariusz", "Stonoga", 1100, 0.7, 1.5);
        InsuranceAgent ubezpieczyciel4 = new InsuranceAgentImpl("Anna", "Jajko", 950, 0.99, 1.5);

        agents.add(ubezpieczyciel1);
        agents.add(ubezpieczyciel2);
        agents.add(ubezpieczyciel3);
        agents.add(ubezpieczyciel4);

        for (Policyholder ub : insurers) {
            makeAnOffer(agents, ub);
            findBestOffer(ub);
        }
    }
}
