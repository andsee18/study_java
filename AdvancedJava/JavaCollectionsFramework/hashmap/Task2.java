package JavaCollectionsFramework.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Задание 2 (Среднее): 
 * Создайте HashMap, где ключом будет имя студента (String), а значением - его оценка от 1 до 5 (Integer).
 * 1. Добавьте в мапу 5 студентов и их оценки.
 * 2. Получите и выведите на экран оценку конкретного студента по его имени.
 * 3. Измените оценку одного из студентов на новую.
 * 4. Удалите одного студента из мапы по имени.
 * 5. С помощью entrySet() или ключей (keySet) пройдитесь в цикле и выведите всех оставшихся студентов и их оценки.
 */
public class Task2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Алексей",4);
        map.put("Андрей",5);
        map.put("Роман",5);
        map.put("Олег",2);
        map.put("Юлия",3);
        System.out.println("Оценка студента Олега = "+ map.get("Олег") );
        map.replace("Андрей",4);
        System.out.println(map.get("Андрей"));
        map.remove("Роман");

        for (Map.Entry <String,Integer> entry: map.entrySet() ){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
}

