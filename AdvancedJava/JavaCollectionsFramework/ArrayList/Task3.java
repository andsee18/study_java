package JavaCollectionsFramework.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        /*
         * Задание 3: Фильтрация списка (оставить только четные числа).
         * 1. Создайте список чисел от 1 до 10.
         * 2. Напишите статический метод filterEvenNumbers, который принимает список и возвращает НОВЫЙ список.
         * 3. В методе пройдитесь по исходному списку циклом (как в Task1), и если число четное (number % 2 == 0),
         *    добавьте его в новый список (с помощью .add).
         * 4. Выведите отфильтрованный список в консоль.
         */

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        // Добавьте числа в список (можно использовать цикл или добавить просто вручную)
        List<Integer> correctNumbers = new ArrayList<>(numbers);
        List <Integer> answer = filterNumbers(correctNumbers);
        System.out.println(answer);
    }
    public static List<Integer> filterNumbers(List<Integer> numbers){
        List<Integer> newNumbers = new ArrayList<>();
        for (Integer value: numbers){
            if (value%2==0){
                newNumbers.add(value);
            }
        }
        return newNumbers;
    }
}

