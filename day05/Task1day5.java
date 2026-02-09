package day05;
public class Task1day5 {
    public static void main(String[] args){
        Car car1 = new Car();
        car1.setModel("BMW");
        car1.setColor("Black");
        car1.setYear(2023);
        System.out.println("Модель " + car1.getModel());
        System.out.println("Цвет "+ car1.getColor());
        System.out.println("Год выпуска " + car1.getYear());
    }
}

class Car {
    private String model;
    private String color;
    private int year;

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
        if (yearCar>2026 || yearCar<1900){
            System.out.println("введи корректный год");
        } else {
            year = yearCar;
        }
    }
    public int getYear(){
        return year;
    }
}