package day12.task5;


import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        MusicArtist artist1 = new MusicArtist("Олег",22);
        MusicArtist artist2 = new MusicArtist("Ваня",32);
        MusicArtist artist3 = new MusicArtist("Анна",25);
        MusicArtist artist4 = new MusicArtist("Серега",42);
        List<MusicArtist> people = new ArrayList<>();
        List<MusicArtist> people1 = new ArrayList<>();
        people.add(artist1);
        people.add(artist2);
        people1.add(artist3);
        people1.add(artist4);
        MusicBand musicBand1 = new MusicBand("Группа ОЛЕГ ВАНЯ",
                2022,people);
        MusicBand musicBand2 = new MusicBand("Группа АННА СЕРЕГА",
                2012,people1);
        people.add(artist1);
        people.add(artist2);
        people1.add(artist3);
        people1.add(artist4);
        MusicBand.printMembers(musicBand1);
        MusicBand.printMembers(musicBand2);
        MusicBand.transferMembers(musicBand1,musicBand2);
        MusicBand.printMembers(musicBand1);
        MusicBand.printMembers(musicBand2);



    }
}
