package JavaForBegginers.day04;
import java.util.Random;
public class Task2Day4 {
    public static void main(String[] args){
        int[] numbers = new int[100];
        Random random = new Random();
        int min = 0;
        int max = 10000;
        int diff = max - min;
        for (int x = 0; x < numbers.length;x++ ){
            numbers[x] = random.nextInt(diff+1) + min;
        }
        int max1 = numbers[0];
        int min1 = numbers[0];
        int zero = 0;
        int sum = 0;
        for (int x: numbers){
            if (x>max1){
                max1 = x;
            }
            if (x<min1){
                min1 = x;
            }
            if (x%10 == 0){
                zero++;
                sum = x + sum;
            }

        }
        System.out.println("наиб "+ max1);
        System.out.println("наим "+ min1);
        System.out.println("колво оканч на 0 "+ zero);
        System.out.println("сумма оканч на 0 "+ sum);
    }
}
