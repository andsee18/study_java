package JavaCollectionsFramework.comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Задание 1 (Легкое):
 * 1. Создайте список (ArrayList) из произвольных строк (например, списка 5 разных языков программирования).
 * 2. Напишите компаратор (отдельный класс или анонимный класс в main),
 * который сортирует строки по их ДЛИНЕ по возрастанию (от самого короткого слова к самому длинному).
 * 3. Отсортируйте список с помощью Collections.sort(list, comparator) и выведите на экран.
 */
public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("C#");
        list.add("Go");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                } else if (s1.length() < s2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(list);

    }
}

