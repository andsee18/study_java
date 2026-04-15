package JavaCollectionsFramework.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Задание 2:
 * Напишите программу, которая создает LinkedList из 10000 случайных целых чисел (от 0 до 999).
 * 1. Найдите сумму всех элементов списка, используя итератор (или цикл for-each).
 * 2. Найдите среднее арифметическое.
 * 3. Удалите из списка все четные числа.
 */
public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            numbers.add((int) ((Math.random()) * 1000));
        }
        int sum = 0;
        for (Integer value : numbers) {
            sum += value;
        }
        System.out.println("сумма всех чисел = " + sum);
        double average = (double) sum / numbers.size();
        System.out.println("среднее значение = " + average);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value % 2 == 0) {
                iterator.remove();
            }
        }
    }
}

