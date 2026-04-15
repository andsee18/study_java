package JavaCollectionsFramework.LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * Задание 1:
 * Создайте LinkedList, содержащий имена 5 ваших друзей.
 * 1. Выведите на экран элементы коллекции.
 * 2. Добавьте одно имя в начало списка и одно в конец.
 * 3. Удалите третье по счету имя.
 * 4. Выведите итоговый список на экран.
 */
public class Task1 {
    public static void main(String[] args) {
        List<String> friends = new LinkedList<>();
        friends.add("Даниил");
        friends.add("Павел");
        friends.add("София");
        friends.add("Анна");
        friends.add("Сергей");
        System.out.println(friends);
        friends.add(0, "Олег");
        friends.add("Евгений");
        friends.remove(2);
        System.out.println(friends);
    }
}

