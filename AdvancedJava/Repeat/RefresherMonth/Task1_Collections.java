package Repeat.RefresherMonth;

import java.util.*;

/**
 * Задание 1: Освежаем в памяти Коллекции
 * <p>
 * Условие:
 * 1. Создайте список (ArrayList) целых чисел от 1 до 20.
 * 2. Удалите из списка все четные числа (вспомни про Итератор или метод removeIf).
 * 3. Создайте словарь (HashMap), где ключом будет оставшееся число, а значением - строка "Number " + число.
 * 4. Выведите все пары ключ-значение на экран.
 */
public class Task1_Collections {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(20);
        for (int i = 1; i < 21; i++)
            numbers.add(i);
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++)
            hashMap.put(numbers.get(i), "Number " + numbers.get(i));
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}

