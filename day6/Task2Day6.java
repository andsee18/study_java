package day6;
import java.util.Scanner;

public class Task2Day6 {
    public static void main(String[] args){
        Airplane airplane1 = new Airplane("Россия", 1999, 20, 5000);

        airplane1.setLength(22);
        airplane1.setYear(2017);

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 3; i++) {
            System.out.println("Введите число для заправки №" + i + ":");
            int sc = scanner.nextInt();
            airplane1.fillUp(sc);
        }

        airplane1.info();
    }
}

class Airplane {
    private String manufacturer;
    private int year;
    private int length;
    private int weight;
    private int fuel;

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
                ", количество топлива в баке: " + fuel);
    }

    void fillUp(int n) {
        if (n <= 0) {
            System.out.println("Неверное значение");
        } else {
            this.fuel += n;
            System.out.println("Заправлено на " + n + " л. Итого: " + this.fuel);
        }
    }
}