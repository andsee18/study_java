package Repeat.september1;

import java.util.ArrayList;
import java.util.List;

/**
 * ЗАДАЧА 1: Базовые операции с MyArrayList
 * <p>
 * УСЛОВИЕ:
 * 1. Создай пустой MyArrayList<Integer>
 * Подсказка: new MyArrayList<>()
 * <p>
 * 2. Выведи начальное состояние (size и capacity)
 * Подсказка: .size() и .capacity()
 * <p>
 * 3. Добавь 15 чисел (от 1 до 15) в список
 * Подсказка: цикл for + .add()
 * <p>
 * 4. После добавления 10-го и 15-го элемента выведи:
 * - size, capacity
 * - сам список (когда выведешь список, его toString() покажет все элементы)
 * <p>
 * 5. Выведи финальное состояние (size и capacity)
 * <p>
 * 6. Получи элементы по индексам: 0, 7, последний
 * Подсказка: .get(индекс), для последнего используй size()-1
 * <p>
 * ВОПРОС: Когда увеличилась capacity с 10 до 15?
 * (Подумай: когда size станет равен capacity, что произойдет при следующем add?)
 */
public class Task1_BasicOperations {
    public static void main(String[] args) {
        // TODO: напиши код здесь
        List<Integer> myList = new ArrayList<>();
        System.out.println(myList.size());
        for (int i = 0; i < 16; i++) {
            if (i == 10 || i == 15) {
                System.out.println(myList.size());
                System.out.println(myList);
            }
            myList.add(i);
        }
        System.out.println(myList.size());
        System.out.println(myList.get(0));
        System.out.println(myList.get(7));
        System.out.println(myList.get(myList.size()-1));
    }
}