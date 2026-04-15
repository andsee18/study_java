package JavaCollectionsFramework.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Задание 3 (Сложное):
 * Дан массив из слов (или длинная строка текста, разбитая по пробелам на элементы массива).
 * Слова в массиве могут повторяться.
 * <p>
 * Напишите программу, которая подсчитывает, сколько раз каждое слово встречается в тексте,
 * используя структуру данных HashMap.
 * - Ключ (Key) — это конкретное слово.
 * - Значение (Value) — это счетчик, сколько раз оно встретилось.
 * <p>
 * После подсчета выведите на экран результат (каждое слово и частоту его появления).
 */
public class Task3 {
    public static void main(String[] args) {
        String testString = "яблоко банан груша яблоко апельсин банан яблоко ананас груша мандарин";
        String[] words = testString.split(" ");

        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        for (String word : words) {
            if (map.containsKey(word)){
                map.put(word,map.get(word)+1);
            } else{
                map.put(word,1);
            }
        }
        System.out.println("слово и частота его появления...");
        for (Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+" : "+ entry.getValue());
        }
    }
}

