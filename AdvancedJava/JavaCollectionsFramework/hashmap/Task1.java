package JavaCollectionsFramework.hashmap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Задание 1 (Легкое): 
 * Создайте коллекцию HashSet для хранения названий стран (String).
 * 1. Добавьте 5 разных стран.
 * 2. Попытайтесь добавить страну, которая уже была добавлена ранее.
 * 3. Выведите размер множества (size) на экран.
 * 4. Пройдитесь по множеству циклом for-each и выведите все страны на экран.
 */
public class Task1 {
    public static void main(String[] args) {
        // HashSet реализует интерфейс Set, а не Map
        Set<String> country = new HashSet<>();
        country.add("Россия");
        country.add("Америка");
        country.add("Египет");
        country.add("Австрия");
        country.add("Турция");
        country.add("Турция");
        System.out.println(country);
        System.out.println(country.size());
        for (String countr:country){
            System.out.print(countr+ " ");
        }



        
    }
}
