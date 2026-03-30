package JavaCollectionsFramework.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        /*
         * Задание 4: Объединение двух списков.
         * 1. Создайте два разных списка строк (например, имена).
         * 2. Напишите статический метод mergeLists, который принимает два списка и возвращает один объединенный.
         * 3. Внутри метода создайте новый список, пройдитесь циклом по первому списку и добавьте элементы,
         *    затем пройдитесь по второму и тоже добавьте их в новый список.
         *    (Подсказка: вместо цикла можно использовать встроенный метод .addAll(), попробуй оба варианта).
         * 4. Выведите итоговый список в консоль.
         */
        List<String> list1 = new ArrayList<>();
        list1.add("Анна");
        list1.add("Иван");
        List<String> list2 = new ArrayList<>();
        list2.add("Петр");
        list2.add("Мария");

        List<String> result = mergeLists(list1,list2);
        System.out.println(result);

    }
    public static List<String> mergeLists(List<String> list1, List <String> list2){
        List<String> result = new ArrayList<>();
        for(String name: list1){
            result.add(name);
        }
        result.addAll(list2);
        return result;
    }
}

