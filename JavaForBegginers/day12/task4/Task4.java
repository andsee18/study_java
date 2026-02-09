package JavaForBegginers.day12.task4;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<String> people = new ArrayList<>();
        people.add("Андрейка");
        people.add("Иван Шалапайка");
        List<String> people1 = new ArrayList<>();
        people1.add("Анна");
        people1.add("Иван гей клуб");
        MusicBand musicBand1 = new MusicBand("Моя группа",1999,people);
        MusicBand musicBand2 = new MusicBand("Моя группа 2",2009,people1);
        MusicBand.printMembers(musicBand1);
        MusicBand.printMembers(musicBand2);
        MusicBand.transferMembers(musicBand1,musicBand2);
        MusicBand.printMembers(musicBand1);
        MusicBand.printMembers(musicBand2);

    }
}
