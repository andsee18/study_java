package JavaForBegginers.day07;

public class Task1Day7 {
    public static void main(String[] args){
        Airplane airplane1 = new Airplane("Россия", 1999, 20, 5000);
        Airplane airplane2 = new Airplane("Америка", 2005,16,4000);
        airplane1.info();
        airplane2.info();
        Airplane.compareAirplanes(airplane1, airplane2);


        /*
        airplane1.setLength(22);
        airplane1.setYear(2017);

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 3; i++) {
            System.out.println("Введите число для заправки №" + i + ":");
            int sc = scanner.nextInt();
            airplane1.fillUp(sc);
        }

        airplane1.info();
 */
    }
}

class Airplane {
    private String manufacturer;
    private int year;
    private int length;
    private int weight;
    private int fuel;

    public static void compareAirplanes(Airplane airplane1, Airplane airplane2){
        int value = airplane1.getLength() - airplane2.getLength();
        if (value<0){
            value = value*(-1);
            System.out.println("самолёт " + airplane2.manufacturer + " длиннее на "+ value);
        } else {
            System.out.println("самолёт " + airplane1.manufacturer + " длиннее на "+ value);
        }
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
    public int getLength(){ return length;}

    void info() {
        System.out.println("Изготовитель: " + manufacturer +
                ", год выпуска: " + year +
                ", длина: " + length +
                ", вес: " + weight +
                ", количество топлива в баке: " + fuel);
    }
/*
    void fillUp(int n) {
        if (n <= 0) {
            System.out.println("Неверное значение");
        } else {
            this.fuel += n;
            System.out.println("Заправлено на " + n + " л. Итого: " + this.fuel);
        }
    }
  */
}