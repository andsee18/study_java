package JavaForBegginers.day04;
import java.util.Scanner;
public class Task1Day4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int r =  scanner.nextInt();
        int[] numbers = new int[r];
        for (int x = 0;x < numbers.length;x++){
            numbers[x] = (int) (Math.random() * (10 + 1 ));
        }
        System.out.println( "введено число " + r + " . Сгенерирован следующий массив:");
        int eight = 0;
        int one = 0;
        int chet = 0;
        int nechet = 0;
        int sum = 0;
        for (int i:numbers){
            System.out.print(i+ ", ");
            sum = i+ sum;
            if (i>8){
                eight++;
            }
            if (i==1){
                one++;
            }
            if (i%2==0){
                chet++;
            } else {
                nechet++;
            }
        }
        System.out.println("Количество чисел больше 8: "+ eight);
        System.out.println("Количество чисел равных 1: "+ one);
        System.out.println("Количество четных чисел: "+ chet);
        System.out.println("Количество нечетных чисел:  "+ nechet);
        System.out.println("Сумма"+ sum);
    }
}
