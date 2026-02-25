import java.util.ArrayList;
import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        int[] numbers = new int [50];
        int x = 0;
        for(int i = 0; i<numbers.length; i++){
            numbers[i] = x;
            x++;
        }

        List <Integer> list = new ArrayList();
        for (int number: numbers){
            if (number%2==0){
                list.add(number);
            } else {
                System.out.print(number+" ");
            }
        }
        System.out.println(list);
    }
}
