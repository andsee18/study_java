package Repeat.september1;

import java.util.ArrayList;
import java.util.List;

/**
 * ЗАДАЧА 2: Удаление элементов (remove)
 * <p>
 * УСЛОВИЕ:
 * 1. Создай массив фруктов: "яблоко", "банан", "апельсин", "груша", "киви", "манго"
 * Подсказка: String[] fruits = {...}
 * <p>
 * 2. Добавь все фрукты в MyArrayList<String>
 * Подсказка: цикл for + .add()
 * <p>
 * 3. Выведи начальный список и size
 * Подсказка: System.out.println(list)
 * <p>
 * 4. Удали элемент с индексом 2 ("апельсин") используя remove(index)
 * Подсказка: .remove(2) вернет удаленный элемент
 * <p>
 * 5. Выведи список после удаления и новый size
 * <p>
 * 6. Удали "киви" используя remove(Object)
 * Подсказка: .remove("киви") вернет true/false
 * <p>
 * 7. Выведи список и проверь что киви удален
 * <p>
 * 8. Попытайся удалить "ананас" (его нет в списке)
 * Подсказка: проверь что возвращает remove()
 * <p>
 * 9. Удали первый элемент, потом последний
 * Подсказка: .remove(0) и .remove(size()-1)
 * <p>
 * ВОПРОС: Что происходит с остальными элементами когда ты удаляешь один?
 */
public class Task2_RemoveOperations {
    public static void main(String[] args) {
        // TODO: напиши код здесь
        String fruits[] = {"яблоко", "банан", "апельсин", "груша", "киви", "манго"};
        List<String> myList = new ArrayList<>();
        for (int i = 0; i < fruits.length; i++)
            myList.add(fruits[i]);
        System.out.println(myList);
        System.out.println(myList.size());

        myList.remove(2);
        System.out.println(myList);
        System.out.println(myList.size());

        myList.remove("киви");
        System.out.println(myList);

        System.out.println(myList.remove("ананас"));

        myList.remove(0);
        myList.remove(myList.size() - 1);


    }
}