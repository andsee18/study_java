package day06;
import java.util.Scanner;
public class Task1day5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int scan = scanner.nextInt();
        Car car1 = new Car();
        car1.setModel("BMW");
        car1.setColor("Black");
        car1.setYear(2010);
        car1.info();
        int rez = car1.yearDifference(scan);
        System.out.println("результат = "+ rez);


        System.out.println("Модель " + car1.getModel());
        System.out.println("Цвет "+ car1.getColor());
        System.out.println("Год выпуска " + car1.getYear());
    }
}

class Car {
    private String model;
    private String color;
    private int year;
    void info(){
        System.out.println("это автомобиль");
    }
    int yearDifference(int inputYear){
        if (inputYear<0){
            inputYear = inputYear * (-1);
        }
        int x = inputYear - this.year;
        if (x<0){
            x = x * (-1);
        }
        return x;
    }

    public void setModel (String modelCar){
        if (modelCar.isEmpty()){
            System.out.println("введи данные");
        } else {
        model = modelCar;}
    }
    public String getModel(){
        return model;
    }

    public void setColor (String colorCar) {
        if (colorCar.isEmpty()){
            System.out.println("введи данные");
        } else {
            color = colorCar;
        }
    }

    public String getColor() {
        return color;
    }

    public void setYear(int yearCar){
            year = yearCar;
    }
    public int getYear(){
        return year;
    }
}