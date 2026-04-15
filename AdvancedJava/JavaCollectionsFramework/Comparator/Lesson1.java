package JavaCollectionsFramework.Comparator;

import java.util.*;

public class Lesson1 {
    public static void main(String[] args) {
//        List<String> animals = new ArrayList<>();
//
//        animals.add("dog");
//        animals.add("cat");
//        animals.add("frog");
//        animals.add("a");
//        animals.add("bird");
//        animals.add("asdfg");
//        animals.add("you");
//
//        Collections.sort(animals,new StringLengthComparator());
//        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 > o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(numbers);
    }
}

class Person{
    private int id;
    private String name;
}