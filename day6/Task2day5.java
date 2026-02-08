package day6;
import java.util.Scanner;

public class Task2day5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        Motorbike motorbike1 = new Motorbike("BMW","красный", 2002);
        Motorbike motorbike2 = new Motorbike("Астра", "синий", 2014);
        motorbike2.info();
        int rez = motorbike2.yearDifference(i);
        System.out.println(motorbike2.getModel()+ " " + motorbike2.getColor() + " " + motorbike2.getYear());
        System.out.println("результат = " + rez);
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
    void info(){
        System.out.println("это мотоцикл " + model);
    }
    int yearDifference(int inputYear){
        if (inputYear < 0) {
            inputYear = inputYear * (-1);
        }
        int x = inputYear - this.year;
        if (x<0){
            x = x* (-1);
        }
        return x;
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