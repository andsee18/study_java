package day04;
import java.util.Random;
public class Task4Day4 {
    public static void main(String[] args){
        int[] numbers = new int[100];
        Random random = new Random();
        int sum = 0;
        for (int x=0; x<numbers.length;x++){
            numbers[x]= random.nextInt(10001);
        }
        int maxSum = 0;
        int index = 0;
        for (int x=0; x<numbers.length-2;x++){
            int y = numbers[x]+numbers[x+1]+numbers[x+2];
            if (y>maxSum){
                maxSum = y;
                index = x;
            }
        }
        System.out.println(maxSum);
        System.out.println(index);
    }
}
