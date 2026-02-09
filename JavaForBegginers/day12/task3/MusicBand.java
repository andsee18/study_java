package JavaForBegginers.day12.task3;

public class MusicBand {
    private String name;
    private int year;
    public MusicBand(String name, int year){
        this.name = name;
        this.year = year;
    }
    public String getName(){
        return  this.name;
    }
    public int getYear(){
        return  this.year;
    }
    @Override
    public String toString(){
        return "группа = "+ name + "; год = "+ year;
    }
}
