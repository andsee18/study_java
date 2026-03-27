package JavaCollectionsFramework.ArrayList;


import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        Task1 task = new Task1();
        List<Integer> cleanList = removeDuplicates(numbers);
        System.out.println(cleanList);
    }

    public static List<Integer> removeDuplicates(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for (Integer number: list){
            if (!result.contains(number)){
                result.add(number);
            }
        }
        return result;
    }
}
