package JavaForBegginers.day02;
import java.util.Scanner;
public class Task2Day2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a >= b) {
            System.out.println("некорректный ввод");
        } else {
                for (int m = a + 1; m < b; m++) {
                    if (m % 5 == 0 && m % 10 != 0) {
                        System.out.print(m + " ");
                    }
                }
            }
        }
    }

