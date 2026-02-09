package JavaForBegginers.day12;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> auto = new ArrayList<>();
        auto.add("BMW");
        auto.add("MERCEDES");
        auto.add("toyota");
        auto.add("Жигули");
        auto.add("Camry");
        System.out.println(auto);
        auto.add(3,"PORSCHE");
        auto.remove(0);
        System.out.println(auto);
    }
}
