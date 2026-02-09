package JavaForBegginers.day08;

public class Task2Day8 {
    public static void main(String[] args){
        Airplane airplane1 = new Airplane("Россия", 1999, 20, 5000);
        System.out.println(airplane1);


    }
}

class Airplane {
    private String manufacturer;
    private int year;
    private int length;
    private int weight;
    private int fuel;

    public String toString(){
        return "Изготовитель " + manufacturer +", год выпуска: " + year + ", длина: " + length + ", вес: " +weight +  ", количество топлива в баке: "+fuel;
    }

    public Airplane(String manufacturer, int year, int length, int weight) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.length = length;
        this.weight = weight;
        this.fuel = 0; // Всегда 0 при создании
    }

    // Сеттеры
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setYear(int year) { this.year = year; }
    public void setLength(int length) { this.length = length; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setFuel(int fuel) { this.fuel = fuel; }

    // Геттер для топлива
    public int getFuel() { return fuel; }

    void info() {
        System.out.println("Изготовитель: " + manufacturer +
                ", год выпуска: " + year +
                ", длина: " + length +
                ", вес: " + weight +
                ", количество топлива в баке: " + fuel);}}