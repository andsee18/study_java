package day12.task5;

import java.util.List;

public class MusicBand {
    private String groupName;
    private int year;
    private List<MusicArtist> humanName;
    public MusicBand(String groupName, int year, List<MusicArtist> humanName){
        this.groupName = groupName;
        this.year = year;
        this.humanName = humanName;
    }
    public List<MusicArtist> getMembers(){
        return this.humanName;
    }
    public String getGroupName(){
        return  this.groupName;
    }
    public int getYear(){
        return  this.year;
    }

    public static void transferMembers(MusicBand group1, MusicBand group2){
        group2.getMembers().addAll(group1.getMembers());
        group1.getMembers().clear();
        }
    @Override
    public String toString(){
        return "группа = "+ groupName + "; год = "+ year;
    }
    public static void  printMembers(MusicBand group){
        System.out.println("Список участников группы "+ group.getGroupName());
        if (group.getMembers().isEmpty()){
            System.out.println("группа без участников");
            return;
        }
        for(int i = 0;i<group.getMembers().size();i++){
            System.out.println(group.getMembers().get(i));
        }
    }
}

