package JavaForBegginers.day02;
import java.util.Scanner;
public class Task1Day2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("введи колво этажей");
        int s = scanner.nextInt();
        if (s>0 && s<5) {
            System.out.println("малоэтажный дом");
        } else if (s>4 && s<9) {
            System.out.println("среднеэтажный дом");
        } else if (s > 8){
            System.out.println("многоэтажный дом");
        } else {
            System.out.println("ошибка ввода");
        }
    }
}
