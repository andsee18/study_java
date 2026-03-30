package JavaCollectionsFramework.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        /*
         * Задание 2: Найти максимальное число в ArrayList.
         * 1. Создайте список чисел и добавьте в него несколько произвольных значений.
         * 2. Напишите статический метод findMax, который принимает список чисел и возвращает максимальное.
         * 3. Переберите список в цикле for-each, чтобы найти самое большое число.
         * 4. Выведите результат метода в консоль.
         */

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(25);
        numbers.add(3);
        int max = findMax(numbers);
        System.out.println(max);


        // int max = findMax(numbers);
        // System.out.println("Максимальное число: " + max);
    }
    public static int findMax(List<Integer> numbers){
        int x = numbers.get(0);
        for(Integer value: numbers){
            if (value>x){
                x = value;
            }
        }
        return x;
    }
}

