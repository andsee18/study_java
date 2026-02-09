package JavaForBegginers.day12.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<MusicBand> list = new ArrayList<>(Arrays.asList(
                new MusicBand("The Beatles",1960),
                new MusicBand("Pink Floyd",1965),
                new MusicBand("Queen",1970),
                new MusicBand("Metallica",1981),
                new MusicBand("Nirvana",1987),
                new MusicBand("Arctic Monkeys", 2002),
                new MusicBand("Imagine Dragons",2008),
                new MusicBand("Twenty One Pilots",2009),
                new MusicBand("Royal Blood", 2013),
                new MusicBand("Maneskin",2016)
        ));
        System.out.println("оригинальный список");
        for(MusicBand band: list){
            System.out.println(band);
        }
        Collections.shuffle(list);
        System.out.println("список после шафла");
        for(MusicBand band: list){
            System.out.println(band);
        }
        System.out.println("сортированный список");
        for(MusicBand band: groupAfter2000(list)){
            System.out.println(band);
        }


    }
    public static List<MusicBand> groupAfter2000(List<MusicBand> bands){
        List<MusicBand> myGroup = new ArrayList<>();
        for(MusicBand group: bands){
            if(group.getYear()>2000){
                myGroup.add(group);
            }
        } return myGroup;
    }
}
