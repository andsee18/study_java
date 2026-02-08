package day3;
import java.util.Scanner;
public class Task3Day3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        for(int x = 0; x<5; x++){
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            if (b == 0){
                System.out.println("деление на 0");
                continue;
            }
            System.out.println(a/b);
        }
        System.out.println("конец цикла");
    }
}
