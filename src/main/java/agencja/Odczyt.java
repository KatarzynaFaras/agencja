package agencja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Odczyt {

    private String nazwaPliku;

    public static ArrayList<String> odczyt(String nazwaPliku, int coIleLinii) throws FileNotFoundException {
        File file = new File(nazwaPliku);
        Scanner in = new Scanner(file);
        ArrayList<String> odczyt = new ArrayList<String>();
        try {
            do {
                odczyt.add(in.next());
            } while (in != null);

        } catch (NoSuchElementException nsee) {

        }
        return odczyt;
    }

    public static void wypiszTabliceZOdczytu(ArrayList<String> lista) {
        for (String s : lista) {
            System.out.println(s);
        }
    }
}
