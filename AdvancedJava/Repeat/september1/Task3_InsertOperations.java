package Repeat.september1;

import java.util.ArrayList;
import java.util.List;

/**
 * ЗАДАЧА 3: Вставка в середину (add с индексом)
 * 
 * УСЛОВИЕ:
 * Создай список из чисел [10, 20, 30, 40]
 * Вставь число 25 на индекс 2 (должно быть перед 30)
 * Вставь число 5 в начало (индекс 0)
 * Вставь число 50 в конец
 * 
 * Выведи финальный список и проверь индексы
 */
public class Task3_InsertOperations {
    public static void main(String[] args) {
        // TODO: напиши код здесь
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(2,25);
        numbers.add(0,5);
        numbers.add(numbers.size(),50);
        System.out.println(numbers);
    }
}
