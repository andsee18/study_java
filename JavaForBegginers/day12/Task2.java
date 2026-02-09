package JavaForBegginers.day12;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        myMet(0,30,numbers);
        myMet(300,350,numbers);
        System.out.println(numbers);
    }
    public static void myMet(int m, int l,List<Integer> numbers){
        for(int i = m; i < l; i++){
            if (i%2==0){
                numbers.add(i);
            }
        }
    }
}
