package day02;
import java.util.Scanner;
public class Task3Day2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int m = x+1;
        if (x>=y){
            System.out.println("неверный ввод");
        } else {
            while (m<y){
                if (m%5 == 0 && m%10!=0){
                    System.out.print(m + " ");
                }
                m++;
            }
        }
    }
}
