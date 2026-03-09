package day19;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaxiRandom {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter("JavaForBegginers/resources/taxi.txt");) {
            for (int i = 0; i < 500; i++) {
                int x = (int) (Math.random() * 100);
                int y = (int) (Math.random() * 100);
                pw.println(i + 1 + " " + x + " " + y);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
