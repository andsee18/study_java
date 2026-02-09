package JavaForBegginers.day05;

public class Task2day5 {
    public static void main(String[] args){
        Motorbike motorbike1 = new Motorbike("BMW","красный", 2009);
        System.out.println(motorbike1.getModel()+ " " + motorbike1.getColor() + " " + motorbike1.getYear());
    }
}
class Motorbike {
    private String model;
    private String color;
    private int year;
    public Motorbike(String model, String color, int year){
        if (model.isEmpty()){
            System.out.println("введи модель мотоцикла");
        } else {
            this.model = model;
        }
        this.color = color;
        if (year<2000) {
            System.out.println("слишком старый мот");
        } else {
        this.year = year;}
    }
    public String getModel(){
        return model;
    }
    public String getColor(){
        return color;
    }
    public int getYear(){
        return year;
    }
}